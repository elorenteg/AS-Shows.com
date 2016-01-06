package showscom.domainLayer.domainControllers;

import java.util.Date;
import java.util.List;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Entrada;
import showscom.domainLayer.domainModel.Local;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.Seient;
import showscom.domainLayer.domainModel.ShowsCom;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeient;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.exceptions.DOPagamentNoAutoritzat;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.factories.CtrlDataFactory;
import showscom.domainLayer.factories.CtrlUseCaseFactory;

public class CtrlDomComprarEntrada {
	private String titol;
	private Date data;
	private String sessio;
	private String nomL;
	private int nombreEspectadors;
	private int preuTotal;
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

	public List<TuplaSeient> obteOcupacio(String nomL, String sessio, int nombreEspectadors) throws DOSeientsNoDisp {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarOcupacio ctrlConsOcup = ctrlUseCaseFact.getCtrlConsultarOcupacio();
		List<TuplaSeient> llista = ctrlConsOcup.consultaOcupacio(nomL, sessio, nombreEspectadors);
		this.nomL = nomL;
		this.nombreEspectadors = nombreEspectadors;
		return llista;
	}

	public TuplaSeient obteMarges(String nomL) throws CDLocalNoExisteix {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlLocal ctrlLocal = ctrlDataFact.getCtrlLocal();
		Local l = ctrlLocal.getLocal(nomL);
		List<Seient> seients = l.getSeients();
		int maxCol = 0;
		int maxFila = 0;
		for (Seient s : seients) {
			int col = s.getColumna();
			int fila = s.getFila();
			if (col > maxCol)
				maxCol = col;
			if (fila > maxFila)
				maxFila = fila;
		}
		TuplaSeient tupla = new TuplaSeient();
		tupla.setFila(maxFila);
		tupla.setColumna(maxCol);
		return tupla;
	}

	public void pagament(String dni, int codiB, String numCompte) throws DOPagamentNoAutoritzat, DOServeiNoDisponible {
		ShowsCom showsCom = ShowsCom.getInstance();
		int c = showsCom.getCodiBanc();
		String n = showsCom.getNumeroCompte();
		int v = showsCom.incrementaVenudes();
		Date dAvui = new Date();
		IBankServiceAdapter adap = new BankServiceAdapter();
		if (!adap.autoritza(dni, codiB, numCompte, preuTotal, c, n, dAvui))
			throw new DOPagamentNoAutoritzat();
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepresentacio = ctrlDataFactory.getCtrlRepresentacio();
		Representacio r = null;
		try {
			r = ctrlRepresentacio.getRepresentacio(sessio, nomL);
		} catch (CDRepresentacioNoExisteix e) {
			// Do nothing. Mai s'executa
		}
		// TODO guardar nueva instancia de Entrada
		Entrada entrada = new Entrada(Integer.toString(v), dni, nombreEspectadors, dAvui, preuTotal, r, seients);
	}
}
