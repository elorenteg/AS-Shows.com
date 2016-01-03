package showscom.domainLayer.domainControllers;

import java.util.List;

import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.TuplaSeientLl;
import showscom.domainLayer.factories.CtrlDataFactory;

public class CtrlConsultarOcupacio {

	public List<TuplaSeientLl> consultaOcupacio(String nomL, String sessio, int nombreEspectadors) throws CDRepresentacioNoExisteix, DOSeientsNoDisp {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlRepresentacio ctrlRepr = ctrlDataFact.getCtrlRepresentacio();
		Representacio r = ctrlRepr.getRepresentacio(nomL, sessio);
		List<TuplaSeientLl>oc = r.obteSeientsLliures(nombreEspectadors);
		return oc;
	}
}
