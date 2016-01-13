package showscom.domainLayer.factories;

import showscom.domainLayer.domainControllers.CtrlConsultarOcupacio;
import showscom.domainLayer.domainControllers.CtrlConsultarRepresentacions;
import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;

/**
 * Gestiona la creacio dels controladors de cas d'Us
 */
public class CtrlUseCaseFactory {
	// Instancia del CtrlUseCaseFactory
	private static CtrlUseCaseFactory instance = new CtrlUseCaseFactory();
	// Instancia del CtrlDomComprarEntrada
	private static CtrlDomComprarEntrada ctrlDomCompEnt;
	// Instancia del CtrlConsultarRepresentacions
	private static CtrlConsultarRepresentacions ctrlConsRepr;
	// Instancia del CtrlConsultarOcupacio
	private static CtrlConsultarOcupacio ctrlConsOcup;

	/**
	 * Un Constructor privat preveu que una altra classe instancii la classe
	 */
	private CtrlUseCaseFactory() {
	}

	/**
	 * Consulta la instancia del CtrlUseCaseFactory
	 * @return instancia de CtrlUseCaseFactory
	 */
	public static CtrlUseCaseFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instancia del CtrlDomComprarEntrada
	 * @return instancia de CtrlDomComprarEntrada
	 */
	public static CtrlDomComprarEntrada getCtrlDomCompEnt() {
		return new CtrlDomComprarEntrada();
	}

	/**
	 * Consulta la instancia del CtrlConsultarRepresentacions
	 * @return instancia de CtrlConsultarRepresentacions
	 */
	public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
		return new CtrlConsultarRepresentacions();
	}

	/**
	 * Consulta la instancia del CtrlConsultarOcupacio
	 * @return instancia de CtrlConsultarOcupacio
	 */
	public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
		return new CtrlConsultarOcupacio();
	}
}
