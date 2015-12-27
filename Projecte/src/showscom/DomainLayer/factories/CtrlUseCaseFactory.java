package showscom.DomainLayer.factories;

import showscom.DomainLayer.domain_controllers.CtrlConsultarOcupacio;
import showscom.DomainLayer.domain_controllers.CtrlConsultarRepresentacions;
import showscom.DomainLayer.domain_controllers.CtrlDomComprarEntrada;

public class CtrlUseCaseFactory {
	private static CtrlUseCaseFactory instance = new CtrlUseCaseFactory();
	private static CtrlDomComprarEntrada ctrlDomCompEnt;
	private static CtrlConsultarRepresentacions ctrlConsRepr;
	private static CtrlConsultarOcupacio ctrlConsOcup;
	
	private CtrlUseCaseFactory() {}

	public static CtrlDomComprarEntrada getCtrlDomCompEnt() {
		return new CtrlDomComprarEntrada();
	}
	
	public static CtrlUseCaseFactory getInstance() {
		return instance;
	}

	public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
		return new CtrlConsultarRepresentacions();
	}

	public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
		return new CtrlConsultarOcupacio();
	}
}
