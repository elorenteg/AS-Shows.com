package showscom.domainLayer.factories;

import showscom.dataLayer.dataControllers.CtrlEspectacle;
import showscom.dataLayer.dataControllers.CtrlRepresentacio;
import showscom.domainLayer.dataInterface.ICtrlEntrada;
import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.dataInterface.ICtrlSeientEnRepresentacio;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = new CtrlDataFactory();
	private static ICtrlEspectacle ctrlEsp;
	private static ICtrlRepresentacio ctrlRepr;
	private static ICtrlSeientEnRepresentacio ctrlSeientRepr;
	private static ICtrlEntrada ctrlEnt;
	private static ICtrlLocal ctrlLoc;

	private CtrlDataFactory() {
		ctrlEsp = new CtrlEspectacle();
		ctrlRepr = new CtrlRepresentacio();
		// ctrlSeientRepr = new CtrlSeientEnRepresentacio();
		// ctrlEnt = new CtrlEntrada();
	}

	public static CtrlDataFactory getInstance() {
		return instance;
	}

	public static ICtrlEspectacle getCtrlEspectacle() {
		return ctrlEsp;
	}

	public static ICtrlRepresentacio getCtrlRepresentacio() {
		return ctrlRepr;
	}

	public static ICtrlSeientEnRepresentacio getCtrlSeientEnRepresentacio() {
		return ctrlSeientRepr;
	}

	public static ICtrlEntrada getCtrlEntrada() {
		return ctrlEnt;
	}

	public ICtrlLocal getCtrlLocal() {
		return ctrlLoc;
	}

}
