package showscom.domainLayer.factories;

import showscom.domainLayer.domainControllers.CtrlConsultarOcupacio;
import showscom.domainLayer.domainControllers.CtrlConsultarRepresentacions;
import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;

public class CtrlUseCaseFactory {
	private static CtrlUseCaseFactory instance = new CtrlUseCaseFactory();
	private static CtrlDomComprarEntrada ctrlDomCompEnt;
	private static CtrlConsultarRepresentacions ctrlConsRepr;
	private static CtrlConsultarOcupacio ctrlConsOcup;

	private CtrlUseCaseFactory() {
	}

	public static CtrlUseCaseFactory getInstance() {
		return instance;
	}

	public static CtrlDomComprarEntrada getCtrlDomCompEnt() {
		return new CtrlDomComprarEntrada();
	}

	public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
		return new CtrlConsultarRepresentacions();
	}

	public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
		return new CtrlConsultarOcupacio();
	}
}
