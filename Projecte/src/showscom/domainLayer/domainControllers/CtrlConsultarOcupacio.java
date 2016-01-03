package showscom.domainLayer.domainControllers;

import java.util.List;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.TuplaSeientLl;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.factories.CtrlDataFactory;

public class CtrlConsultarOcupacio {

	public List<TuplaSeientLl> consultaOcupacio(String nomL, String sessio, int nombreEspectadors)
			throws DOSeientsNoDisp {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepr = ctrlDataFact.getCtrlRepresentacio();
		List<TuplaSeientLl> oc = null;
		try {
			Representacio r = ctrlRepr.getRepresentacio(nomL, sessio);
			oc = r.obteSeientsLliures(nombreEspectadors);
		} catch (CDRepresentacioNoExisteix e) {
			// Do nothing. Mai s'executa
		}

		return oc;
	}
}
