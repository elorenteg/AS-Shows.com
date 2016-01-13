package showscom.domainLayer.factories;

import showscom.domainLayer.domainControllers.CtrlConsultarOcupacio;
import showscom.domainLayer.domainControllers.CtrlConsultarRepresentacions;
import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;

/**
 * Gestiona la creaci� dels controladors de cas d'�s
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
	 * Consulta la inst�ncia del CtrlUseCaseFactory
	 * @return inst�ncia de CtrlUseCaseFactory
	 */
	public static CtrlUseCaseFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la inst�ncia del CtrlDomComprarEntrada
	 * @return inst�ncia de CtrlDomComprarEntrada
	 */
	public static CtrlDomComprarEntrada getCtrlDomCompEnt() {
		return new CtrlDomComprarEntrada();
	}

	/**
	 * Consulta la inst�ncia del CtrlConsultarRepresentacions
	 * @return inst�ncia de CtrlConsultarRepresentacions
	 */
	public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
		return new CtrlConsultarRepresentacions();
	}

	/**
	 * Consulta la inst�ncia del CtrlConsultarOcupacio
	 * @return inst�ncia de CtrlConsultarOcupacio
	 */
	public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
		return new CtrlConsultarOcupacio();
	}
}
