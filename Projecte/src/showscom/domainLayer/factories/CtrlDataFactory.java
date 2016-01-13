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
 * Gestiona la creacio dels controladors de la capa de dades per accedir a la
 * persistencia
 */
public class CtrlDataFactory {
	// Instancia del CtrlDataFactory
	private static CtrlDataFactory instance = new CtrlDataFactory();
	// Instancia del CtrlEspectacle
	private static ICtrlEspectacle ctrlEsp;
	// Instancia del CtrlLocal
	private static ICtrlLocal ctrlLoc;
	// Instancia del CtrlSeient
	private static ICtrlSeient ctrlSeient;
	// Instancia del CtrlSeientEnRepresentacio
	private static ICtrlSeientEnRepresentacio ctrlSeientRepr;
	// Instancia del CtrlRepresentacio
	private static ICtrlRepresentacio ctrlRepr;
	// Instancia del CtrlEntrada
	private static ICtrlEntrada ctrlEnt;
	// Instancia del CtrlShowsCom
	private static ICtrlShowsCom ctrlShows;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin
	 * instanciar la classe. Crea tots els controladors de la capa de dades
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
	 * Consulta la instancia del CtrlDataFactory
	 * @return instancia de CtrlDataFactory
	 */
	public static CtrlDataFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instancia del CtrlEspectacle
	 * @return instancia de CtrlEspectacle
	 */
	public static ICtrlEspectacle getCtrlEspectacle() {
		return ctrlEsp;
	}

	/**
	 * Consulta la instancia del CtrlLocal
	 * @return instancia de CtrlLocal
	 */
	public ICtrlLocal getCtrlLocal() {
		return ctrlLoc;
	}

	/**
	 * Consulta la instancia del CtrlSeient
	 * @return instancia de CtrlSeient
	 */
	public static ICtrlSeient getCtrlSeient() {
		return ctrlSeient;
	}

	/**
	 * Consulta la instancia del CtrlSeientEnRepresentacio
	 * @return instancia de CtrlSeientEnRepresentacio
	 */
	public static ICtrlSeientEnRepresentacio getCtrlSeientEnRepresentacio() {
		return ctrlSeientRepr;
	}

	/**
	 * Consulta la instancia del CtrlRepresentacio
	 * @return instancia de CtrlRepresentacio
	 */
	public static ICtrlRepresentacio getCtrlRepresentacio() {
		return ctrlRepr;
	}

	/**
	 * Consulta la instancia del CtrlEntrada
	 * @return instancia de CtrlEntrada
	 */
	public static ICtrlEntrada getCtrlEntrada() {
		return ctrlEnt;
	}

	/**
	 * Consulta la instancia del CtrlShowsCom
	 * @return instancia de CtrlShowsCom
	 */
	public static ICtrlShowsCom getCtrlShows() {
		return ctrlShows;
	}

}
