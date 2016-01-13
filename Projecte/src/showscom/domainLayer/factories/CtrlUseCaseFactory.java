package showscom.domainLayer.factories;

import showscom.domainLayer.domainControllers.CtrlConsultarOcupacio;
import showscom.domainLayer.domainControllers.CtrlConsultarRepresentacions;
import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;

/**
 * Gestiona la creació dels controladors de cas d'ús
 *
 */
public class CtrlUseCaseFactory {
	/**
	 * Instancia del CtrlUseCaseFactory
	 */
	private static CtrlUseCaseFactory instance = new CtrlUseCaseFactory();
	/**
	 * Instancia del CtrlDomComprarEntrada
	 */
	private static CtrlDomComprarEntrada ctrlDomCompEnt;
	/**
	 * Instancia del CtrlConsultarRepresentacions
	 */
	private static CtrlConsultarRepresentacions ctrlConsRepr;
	/**
	 * Instancia del CtrlConsultarOcupacio
	 */
	private static CtrlConsultarOcupacio ctrlConsOcup;

	/*
	 * Un Constructor privat preveu que una altra classe instancii la classe
	 */
	private CtrlUseCaseFactory() {
	}

	/**
	 * Consulta la instància del CtrlUseCaseFactory
	 * 
	 * @return instància de CtrlUseCaseFactory
	 */
	public static CtrlUseCaseFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instància del CtrlDomComprarEntrada
	 * 
	 * @return instància de CtrlDomComprarEntrada
	 */
	public static CtrlDomComprarEntrada getCtrlDomCompEnt() {
		return new CtrlDomComprarEntrada();
	}

	/**
	 * Consulta la instància del CtrlConsultarRepresentacions
	 * 
	 * @return instància de CtrlConsultarRepresentacions
	 */
	public CtrlConsultarRepresentacions getCtrlConsultarRepresentacions() {
		return new CtrlConsultarRepresentacions();
	}

	/**
	 * Consulta la instància del CtrlConsultarOcupacio
	 * 
	 * @return instància de CtrlConsultarOcupacio
	 */
	public CtrlConsultarOcupacio getCtrlConsultarOcupacio() {
		return new CtrlConsultarOcupacio();
	}
}
