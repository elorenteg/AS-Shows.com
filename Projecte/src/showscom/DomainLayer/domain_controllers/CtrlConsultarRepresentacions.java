package showscom.DomainLayer.domain_controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import showscom.DomainLayer.exceptions.DONoHiHaEspectacles;
import showscom.DomainLayer.exceptions.DONoHiHaRepresentacions;

public class CtrlConsultarRepresentacions {

	public List<String> consultaEspectacles() throws DONoHiHaEspectacles {
		List<String> list = new ArrayList<String>();
		list.add("Lago de los Cisnes");
		list.add("Giselle");
		list.add("Romeo y Julieta");
		list.add("Cascanueces");
		list.add("Cisne Negro");
		list.add("Cenicienta");
		list.add("Don Quijote");
		list.add("La Bella Durmiente");
		list.add("Sueño de una noche de verano");
		list.add("La Bailarina del Templo");
		//throw new DONoHiHaEspectacles();
		return list;
	}

	public List<Object> consultaRepresentacions(String titol, Date data) throws DONoHiHaRepresentacions {
		//throw new DONoHiHaRepresentacions();
		//return new ArrayList<Object>();
		
		List<Object> list = new ArrayList<Object>();
		list.add("Cascanueces");
		list.add("Cisne negro");
		return list;
	}

}
