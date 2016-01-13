package showscom.domainLayer.domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Entrada;
import showscom.domainLayer.domainModel.Local;
import showscom.domainLayer.domainModel.Moneda;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.ShowsCom;
import showscom.domainLayer.domainModel.TuplaPreu;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeient;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.exceptions.DOPagamentNoAutoritzat;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.factories.AdapterFactory;
import showscom.domainLayer.factories.CtrlDataFactory;
import showscom.domainLayer.factories.CtrlUseCaseFactory;

/**
 * Controlador de la Capa de Domini del Cas d'�s de Comprar Entrada
 */
public class CtrlDomComprarEntrada {
	// T�tol de l'espectacle de la representaci�
	private String titol;
	// Data de la representaci� de l'espectacle
	private Date data;
	// Sessi� de la representaci�
	private String sessio;
	// Nom del local de la representaci�
	private String nomL;
	// N�m. d'espectadors a comprar l'entrada
	private int nombreEspectadors;
	// Preu total de la compra de l'entrada
	private float preuTotal;
	// Seients que s'han assignat a la compra
	private List<TuplaSeient> seients;

	/**
	 * Obt� els espectacles disponibles al sistema
	 * @return llista amb els t�tols de tots els espectacles
	 * @throws DONoHiHaEspectacles si no hi ha cap espectacle
	 */
	public List<String> obteEspectacles() throws DONoHiHaEspectacles {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarRepresentacions ctrlConsRepr = ctrlUseCaseFact.getCtrlConsultarRepresentacions();
		return ctrlConsRepr.consultaEspectacles();
	}

	/**
	 * Obt� la informaci� de les representacions per a un espectacle en una data
	 * @param titol t�tol de l'espectacle de la representaci�
	 * @param data data de la representaci�
	 * @return llista amb la informaci� de totes les representacions de
	 *         l'espectacle a la data
	 * @throws DONoHiHaRepresentacions si no hi ha representacions
	 */
	public List<TuplaRepr> obteRepresentacions(String titol, Date data) throws DONoHiHaRepresentacions {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarRepresentacions ctrlConsRepr = ctrlUseCaseFact.getCtrlConsultarRepresentacions();
		List<TuplaRepr> llista = ctrlConsRepr.consultaRepresentacions(titol, data);

		if (llista.isEmpty()) {
			throw new DONoHiHaRepresentacions();
		}
		this.titol = titol;
		this.data = data;

		return llista;
	}

	/**
	 * Obt� la divisa principal de pagament del sistema
	 * @return divisa principal
	 */
	public Moneda obteDivisa() {
		ShowsCom showsCom = ShowsCom.getInstance();
		Moneda divisa = showsCom.getDivisa();
		return divisa;
	}

	/**
	 * Obt� la fila i columna m�xima d'un local
	 * @param nomL nom del local
	 * @return fila i columna m�xima
	 */
	public TuplaSeient obteMarges(String nomL) {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlLocal ctrlLocal = ctrlDataFact.getCtrlLocal();
		Local l = null;
		try {
			l = ctrlLocal.getLocal(nomL);
		} catch (CDLocalNoExisteix e) {
			// Do nothing. Mai s'executa
		}
		TuplaSeient tupla = l.getMarges();
		return tupla;
	}

	/**
	 * Obt� els seients disponibles per a una representaci�
	 * @param nomL nom del local de la representaci�
	 * @param sessio sessi� de la representaci�
	 * @param nombreEspectadors n�m d'espectadors a veure la representaci�
	 * @return llista amb els seients disponibles al local
	 * @throws DOSeientsNoDisp si no hi ha suficients seients al local
	 */
	public List<TuplaSeient> obteOcupacio(String nomL, String sessio, int nombreEspectadors) throws DOSeientsNoDisp {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarOcupacio ctrlConsOcup = ctrlUseCaseFact.getCtrlConsultarOcupacio();
		List<TuplaSeient> llista = ctrlConsOcup.consultaOcupacio(nomL, sessio, nombreEspectadors);
		this.nomL = nomL;
		this.sessio = sessio;
		this.nombreEspectadors = nombreEspectadors;
		return llista;
	}

	/**
	 * Obt� el preu dels seients i les divises de canvi de moneda
	 * @param seients seients a comprar
	 * @return preu total dels seients i divises alternatives de pagament
	 */
	public TuplaPreu seleccionarSeients(List<TuplaSeient> seients) {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepr = ctrlDataFact.getCtrlRepresentacio();
		Representacio repr = null;
		try {
			repr = ctrlRepr.getRepresentacio(nomL, sessio);
		} catch (CDRepresentacioNoExisteix e) {
			// Do nothing. Mai s'executa
		}
		TuplaPreu tupla = new TuplaPreu();
		float preu = repr.getPreu();
		int recarrec = repr.getRecarrec();

		ShowsCom showsCom = ShowsCom.getInstance();
		float comissio = showsCom.getComissio();
		List<Moneda> canvis = showsCom.getCanvis();

		List<String> canvString = new ArrayList<>();
		for (Moneda m : canvis) {
			canvString.add(m.name());
		}

		tupla.setPreu(nombreEspectadors * (preu + comissio + recarrec));
		tupla.setCanvis(canvString);

		this.seients = seients;
		this.preuTotal = tupla.getPreu();

		return tupla;
	}

	/**
	 * Obt� el preu total de l'entrada en una altra divisa
	 * @param moneda divisa alternativa de pagament
	 * @return preu en la nova divisa
	 * @throws DOServeiNoDisponible si el servei de conversi� no est� disponible
	 */
	public float obtePreuMoneda(String moneda) throws DOServeiNoDisponible {
		AdapterFactory adapFact = AdapterFactory.getInstance();
		ICurrencyConvertorAdapter adapConv = adapFact.getCurrencyConvertorAdapter();

		ShowsCom showsCom = ShowsCom.getInstance();
		Moneda divisa = showsCom.getDivisa();
		float conversio = adapConv.conversorRate(divisa.name(), moneda);
		System.out.println("Conversi� " + divisa.name() + "->" + moneda + ": " + conversio);

		return preuTotal * conversio;
	}

	/**
	 * Realitza el pagament de l'entrada
	 * @param dni DNI del client que paga
	 * @param codiB codi del banc del client
	 * @param numCompte n�m. del compte del client
	 * @throws DOPagamentNoAutoritzat si el pagament no s'ha autoritzat
	 * @throws DOServeiNoDisponible si el servei no est� disponible
	 */
	public void pagament(String dni, int codiB, String numCompte) throws DOPagamentNoAutoritzat, DOServeiNoDisponible {
		ShowsCom showsCom = ShowsCom.getInstance();
		int c = showsCom.getCodiBanc();
		String n = showsCom.getNumeroCompte();
		int v = showsCom.incrementaVenudes();
		Date dAvui = new Date();

		AdapterFactory adapFact = AdapterFactory.getInstance();
		IBankServiceAdapter adap = adapFact.getBankServiceAdapter();
		if (!adap.autoritza(dni, codiB, numCompte, preuTotal, c, n, dAvui))
			throw new DOPagamentNoAutoritzat();

		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepresentacio = ctrlDataFactory.getCtrlRepresentacio();
		Representacio r = null;
		try {
			r = ctrlRepresentacio.getRepresentacio(nomL, sessio);
		} catch (CDRepresentacioNoExisteix e) {
			// Do nothing. Mai s'executa
		}
		Entrada entrada = new Entrada(Integer.toString(v), dni, nombreEspectadors, dAvui, preuTotal, r, seients);
	}
}
