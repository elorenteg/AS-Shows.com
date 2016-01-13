package showscom.domainLayer.factories;

import showscom.dataLayer.dataControllers.CtrlEntrada;
import showscom.dataLayer.dataControllers.CtrlEspectacle;
import showscom.dataLayer.dataControllers.CtrlLocal;
import showscom.dataLayer.dataControllers.CtrlRepresentacio;
import showscom.dataLayer.dataControllers.CtrlSeient;
import showscom.dataLayer.dataControllers.CtrlSeientEnRepresentacio;
import showscom.dataLayer.dataControllers.CtrlShowsCom;
import showscom.domainLayer.dataInterface.ICtrlEntrada;
import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.dataInterface.ICtrlSeient;
import showscom.domainLayer.dataInterface.ICtrlSeientEnRepresentacio;
import showscom.domainLayer.dataInterface.ICtrlShowsCom;

/**
 * Gestiona la creació dels controladors de la capa de dades per accedir a la persistencia
 *
 */
public class CtrlDataFactory {
	/**
	 * Instancia del CtrlDataFactory
	 */
	private static CtrlDataFactory instance = new CtrlDataFactory();
	/**
	 * Instancia del CtrlEspectacle
	 */
	private static ICtrlEspectacle ctrlEsp;
	/**
	 * Instancia del CtrlLocal
	 */
	private static ICtrlLocal ctrlLoc;
	/**
	 * Instancia del CtrlSeient
	 */
	private static ICtrlSeient ctrlSeient;
	/**
	 * Instancia del CtrlSeientEnRepresentacio
	 */
	private static ICtrlSeientEnRepresentacio ctrlSeientRepr;
	/**
	 * Instancia del CtrlRepresentacio
	 */
	private static ICtrlRepresentacio ctrlRepr;
	/**
	 * Instancia del CtrlEntrada
	 */
	private static ICtrlEntrada ctrlEnt;
	/**
	 * Instancia del CtrlShowsCom
	 */
	private static ICtrlShowsCom ctrlShows;

	/**
	 * Mètode creador de la classe que crea tots els controladors de la capa de dades
	 */
	private CtrlDataFactory() {
		ctrlEsp = new CtrlEspectacle();
		ctrlLoc = new CtrlLocal();
		ctrlSeient = new CtrlSeient();
		ctrlSeientRepr = new CtrlSeientEnRepresentacio();
		ctrlRepr = new CtrlRepresentacio();
		ctrlEnt = new CtrlEntrada();
		ctrlShows = new CtrlShowsCom();
	}

	/**
	 * Consulta la instància del CtrlDataFactory
	 * 
	 * @return instància de CtrlDataFactory
	 */
	public static CtrlDataFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instància del CtrlEspectacle
	 * 
	 * @return instància de CtrlEspectacle
	 */
	public static ICtrlEspectacle getCtrlEspectacle() {
		return ctrlEsp;
	}

	/**
	 * Consulta la instància del CtrlLocal
	 * 
	 * @return instància de CtrlLocal
	 */
	public ICtrlLocal getCtrlLocal() {
		return ctrlLoc;
	}

	/**
	 * Consulta la instància del CtrlSeient
	 * 
	 * @return instància de CtrlSeient
	 */
	public static ICtrlSeient getCtrlSeient() {
		return ctrlSeient;
	}

	/**
	 * Consulta la instància del CtrlSeientEnRepresentacio
	 * 
	 * @return instància de CtrlSeientEnRepresentacio
	 */
	public static ICtrlSeientEnRepresentacio getCtrlSeientEnRepresentacio() {
		return ctrlSeientRepr;
	}

	/**
	 * Consulta la instància del CtrlRepresentacio
	 * 
	 * @return instància de CtrlRepresentacio
	 */
	public static ICtrlRepresentacio getCtrlRepresentacio() {
		return ctrlRepr;
	}

	/**
	 * Consulta la instància del CtrlEntrada
	 * 
	 * @return instància de CtrlEntrada
	 */
	public static ICtrlEntrada getCtrlEntrada() {
		return ctrlEnt;
	}

	/**
	 * Consulta la instància del CtrlShowsCom
	 * 
	 * @return instància de CtrlShowsCom
	 */
	 public static ICtrlShowsCom getCtrlShows() {
		return ctrlShows;
	}

}
