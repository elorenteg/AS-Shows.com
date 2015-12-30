package showscom.domainLayer.domainControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.domainModel.Espectacle;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.factories.CtrlDataFactory;

public class CtrlConsultarRepresentacions {

	public List<String> consultaEspectacles() throws DONoHiHaEspectacles {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlEspectacle ctrlEsp = ctrlDataFact.getCtrlEspectacle();
		List<Espectacle> es = ctrlEsp.getAllEspectacles();

		if (es.isEmpty()) {
			throw new DONoHiHaEspectacles();
		}

		List<String> titols = new ArrayList<String>();
		for (Espectacle e : es) {
			titols.add(e.getTitol());
		}

		return titols;

		// List<String> list = new ArrayList<String>();
		// list.add("Lago de los Cisnes");
		// list.add("Giselle");
		// list.add("Romeo y Julieta");
		// list.add("Cascanueces");
		// list.add("Cisne Negro");
		// list.add("Cenicienta");
		// list.add("Don Quijote");
		// list.add("La Bella Durmiente");
		// list.add("Sueño de una noche de verano");
		// list.add("La Bailarina del Templo");
		// throw new DONoHiHaEspectacles();
		// return list;
	}

	public List<Object> consultaRepresentacions(String titol, Date data) throws DONoHiHaRepresentacions {
		// throw new DONoHiHaRepresentacions();
		// return new ArrayList<Object>();

		List<Object> list = new ArrayList<Object>();
		list.add("Cascanueces");
		list.add("Cisne negro");
		return list;
	}

}
