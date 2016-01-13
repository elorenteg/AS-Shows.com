package showscom.domainLayer.domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.domainModel.Espectacle;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.factories.CtrlDataFactory;

/**
 * Controlador de la Capa de Domini del Cas d'�s de Consultar Representacions
 */
public class CtrlConsultarRepresentacions {

	/**
	 * Obt� els espectacles disponibles al sistema
	 * @return llista amb els t�tols de tots els espectacles
	 * @throws DONoHiHaEspectacles si no hi ha cap espectacle
	 */
	public List<String> consultaEspectacles() throws DONoHiHaEspectacles {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlEspectacle ctrlEsp = ctrlDataFact.getCtrlEspectacle();
		List<Espectacle> es = ctrlEsp.getAllEspectacle();

		if (es.isEmpty()) {
			throw new DONoHiHaEspectacles();
		}

		List<String> titols = new ArrayList<String>();
		for (Espectacle e : es) {
			titols.add(e.getTitol());
		}

		return titols;
	}

	/**
	 * Obt� la informaci� de les representacions per a un espectacle en una data
	 * @param titol t�tol de l'espectacle de la representaci�
	 * @param data data de la representaci�
	 * @return llista amb la informaci� de totes les representacions de
	 *         l'espectacle a la data
	 * @throws DONoHiHaRepresentacions si no hi ha representacions
	 */
	public List<TuplaRepr> consultaRepresentacions(String titol, Date data) throws DONoHiHaRepresentacions {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlEspectacle ctrlEsp = ctrlDataFact.getCtrlEspectacle();
		List<TuplaRepr> info = null;
		try {
			Espectacle esp = ctrlEsp.getEspectacle(titol);
			info = esp.obteInformacio(data);
		} catch (CDEspectacleNoExisteix e) {
			// Do nothing. Mai s'executa
		}

		return info;
	}

}
