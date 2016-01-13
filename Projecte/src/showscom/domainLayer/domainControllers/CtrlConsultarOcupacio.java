package showscom.domainLayer.domainControllers;

import java.util.List;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.TuplaSeient;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.factories.CtrlDataFactory;

/**
 * Controlador de la Capa de Domini del Cas d'Ús Consultar Ocupació
 */
public class CtrlConsultarOcupacio {

	/**
	 * Obté els seients disponibles al local d'una representació
	 * @param nomL nom del local de la representació
	 * @param sessio sessió de la representació
	 * @param nombreEspectadors núm. d'espectadors a veure la representació
	 * @return llista amb els seients disponibles del local
	 * @throws DOSeientsNoDisp si no hi ha suficients seients disponibles al
	 *         local
	 */
	public List<TuplaSeient> consultaOcupacio(String nomL, String sessio, int nombreEspectadors)
			throws DOSeientsNoDisp {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepr = ctrlDataFact.getCtrlRepresentacio();
		List<TuplaSeient> oc = null;
		try {
			Representacio r = ctrlRepr.getRepresentacio(nomL, sessio);
			oc = r.obteSeientsLliures(nombreEspectadors);
		} catch (CDRepresentacioNoExisteix e) {
			// Do nothing. Mai s'executa
		}

		return oc;
	}
}
