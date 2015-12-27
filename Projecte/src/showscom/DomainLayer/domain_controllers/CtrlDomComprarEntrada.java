package showscom.DomainLayer.domain_controllers;

import java.util.Date;
import java.util.List;

import showscom.DomainLayer.exceptions.DONoHiHaEspectacles;
import showscom.DomainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.DomainLayer.factories.CtrlUseCaseFactory;

public class CtrlDomComprarEntrada {
	private String titol;
	private Date data;

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

}
