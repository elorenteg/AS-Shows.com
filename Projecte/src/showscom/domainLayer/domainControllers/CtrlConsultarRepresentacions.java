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

public class CtrlConsultarRepresentacions {

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
