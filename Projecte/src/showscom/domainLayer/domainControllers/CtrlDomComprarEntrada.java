package showscom.domainLayer.domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;
import showscom.domainLayer.dataInterface.ICtrlEntrada;
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

public class CtrlDomComprarEntrada {
	private String titol;
	private Date data;
	private String sessio;
	private String nomL;
	private int nombreEspectadors;
	private float preuTotal;
	private List<TuplaSeient> seients;

	public List<String> obteEspectacles() throws DONoHiHaEspectacles {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarRepresentacions ctrlConsRepr = ctrlUseCaseFact.getCtrlConsultarRepresentacions();
		return ctrlConsRepr.consultaEspectacles();
	}

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

	public List<TuplaSeient> obteOcupacio(String nomL, String sessio, int nombreEspectadors) throws DOSeientsNoDisp {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarOcupacio ctrlConsOcup = ctrlUseCaseFact.getCtrlConsultarOcupacio();
		List<TuplaSeient> llista = ctrlConsOcup.consultaOcupacio(nomL, sessio, nombreEspectadors);
		this.nomL = nomL;
		this.sessio = sessio;
		this.nombreEspectadors = nombreEspectadors;
		return llista;
	}

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

		tupla.setPreu(nombreEspectadors * (preu + comissio + recarrec));
		tupla.setCanvis(canvis);

		this.seients = seients;
		this.preuTotal = tupla.getPreu();

		return tupla;
	}

	public float obtePreuMoneda(Moneda moneda) throws DOServeiNoDisponible {
		AdapterFactory adapFact = AdapterFactory.getInstance();
		ICurrencyConvertorAdapter adapConv = adapFact.getCurrencyConvertorAdapter();

		ShowsCom showsCom = ShowsCom.getInstance();
		Moneda divisa = showsCom.getDivisa();
		System.out.println("Començo conversió...");
		float conversio = adapConv.conversorRate(divisa.name(), moneda.name());

		System.out.println(conversio);

		return preuTotal * conversio;
	}

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

		// No se puede hacer el guardarEntrada desde aquí ya que en la creadora
		// de entrada se reservan los asientos y para reservar el asiento (con
		// foreign key a Entrada) tiene que estar guardada la entrada en la bd

		// CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		// ICtrlEntrada ctrlEnt = ctrlDataFact.getCtrlEntrada();
		// ctrlEnt.guardaEntrada(entrada);
	}
}
