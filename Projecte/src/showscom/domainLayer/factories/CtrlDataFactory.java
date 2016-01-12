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

public class CtrlDataFactory {
	private static CtrlDataFactory instance = new CtrlDataFactory();
	private static ICtrlEspectacle ctrlEsp;
	private static ICtrlLocal ctrlLoc;
	private static ICtrlSeient ctrlSeient;
	private static ICtrlSeientEnRepresentacio ctrlSeientRepr;
	private static ICtrlRepresentacio ctrlRepr;
	private static ICtrlEntrada ctrlEnt;
	private static ICtrlShowsCom ctrlShows;

	private CtrlDataFactory() {
		ctrlEsp = new CtrlEspectacle();
		ctrlLoc = new CtrlLocal();
		ctrlSeient = new CtrlSeient();
		ctrlSeientRepr = new CtrlSeientEnRepresentacio();
		ctrlRepr = new CtrlRepresentacio();
		ctrlEnt = new CtrlEntrada();
		ctrlShows = new CtrlShowsCom();
	}

	public static CtrlDataFactory getInstance() {
		return instance;
	}

	public static ICtrlEspectacle getCtrlEspectacle() {
		return ctrlEsp;
	}

	public ICtrlLocal getCtrlLocal() {
		return ctrlLoc;
	}

	public static ICtrlSeient getCtrlSeient() {
		return ctrlSeient;
	}

	public static ICtrlSeientEnRepresentacio getCtrlSeientEnRepresentacio() {
		return ctrlSeientRepr;
	}

	public static ICtrlRepresentacio getCtrlRepresentacio() {
		return ctrlRepr;
	}

	public static ICtrlEntrada getCtrlEntrada() {
		return ctrlEnt;
	}

	public static ICtrlShowsCom getCtrlShows() {
		return ctrlShows;
	}

}
