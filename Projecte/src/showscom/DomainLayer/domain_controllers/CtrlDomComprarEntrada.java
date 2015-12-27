package showscom.DomainLayer.domain_controllers;

import java.util.Date;
import java.util.List;

import showscom.DomainLayer.domain_model.Entrada;
import showscom.DomainLayer.domain_model.ShowsCom;
import showscom.DomainLayer.exceptions.DONoHiHaEspectacles;
import showscom.DomainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.DomainLayer.factories.CtrlUseCaseFactory;

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

	public List<Object> obteRepresentacions(String titol, Date data) throws DONoHiHaRepresentacions {
		CtrlUseCaseFactory ctrlUseCaseFact = CtrlUseCaseFactory.getInstance();
		CtrlConsultarRepresentacions ctrlConsRepr = ctrlUseCaseFact.getCtrlConsultarRepresentacions();
		List<Object> llista = ctrlConsRepr.consultaRepresentacions(titol, data);
		
		if (llista.isEmpty()) {
			throw new DONoHiHaRepresentacions();
		}
		this.titol = titol;
		this.data = data;
		
		return llista;
	}
	
	public void pagament(String dni, int codiB, String numCompte) {
		ShowsCom showsCom = ShowsCom.getInstance();
		int c = showsCom.getCodiBanc();
		String n = showsCom.getNumeroCompte();
		int v = showsCom.incrementaVenudes();
		// TODO obtener adaptador banco
		// CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		// CtrlRepresentacio ctrlRepresentacio = ctrlDataFactory.getCtrlRepresentacio();
		// Representacio r = ctrlRepresentacio.getRepresentacio(sessio, nomL);
		// Entrada entrada = new Entrada(Integer.toString(v), dni, nombreEspectadors, new Date(), preuTotal, r, seients);		
	}

}
