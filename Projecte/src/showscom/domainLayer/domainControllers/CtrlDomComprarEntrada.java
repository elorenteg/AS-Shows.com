package showscom.domainLayer.domainControllers;

import java.util.Date;
import java.util.List;

import showscom.domainLayer.domainModel.ShowsCom;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeientLl;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.exceptions.DOPagamentNoAutoritzat;
import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.factories.CtrlUseCaseFactory;

public class CtrlDomComprarEntrada {
	private String titol;
	private Date data;
	private String sessio;
	private String nomL;
	private int nombreEspectadors;
	private int preuTotal;
	private Object seients;

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
	
	public List<TuplaSeientLl> obteOcupacio(String nomL, String sessio, int nombreEspectadors) {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarOcupacio ctrlConsOcup = ctrlUseCaseFact.getCtrlConsultarOcupacio();
		List<TuplaSeientLl> llista = ctrlConsOcup.consultaOcupacio(nomL,sessio,nombreEspectadors);
		this.nomL = nomL;
		this.nombreEspectadors = nombreEspectadors;
		return llista;
	}

	public void pagament(String dni, int codiB, String numCompte) throws DOPagamentNoAutoritzat, DOServeiNoDisponible {
		ShowsCom showsCom = ShowsCom.getInstance();
		int c = showsCom.getCodiBanc();
		String n = showsCom.getNumeroCompte();
		int v = showsCom.incrementaVenudes();
		// TODO obtener adaptador banco
		// CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		// CtrlRepresentacio ctrlRepresentacio =
		// ctrlDataFactory.getCtrlRepresentacio();
		// Representacio r = ctrlRepresentacio.getRepresentacio(sessio, nomL);
		// Entrada entrada = new Entrada(Integer.toString(v), dni,
		// nombreEspectadors, new Date(), preuTotal, r, seients);
	}
}
