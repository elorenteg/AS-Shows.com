package showscom.DomainLayer.domain_model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Espectacle {
	private String titol;
	private int participants;
	private List<Representacio> representacions;
	
	public Espectacle(String titol, int participants) {
		super();
		this.titol = titol;
		this.participants = participants;
	}
	
	public String getTitol() {
		return titol;
	}
	
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	public int getParticipants() {
		return participants;
	}
	
	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public List<Representacio> getRepresentacions() {
		return representacions;
	}

	public void setRepresentacions(List<Representacio> representacions) {
		this.representacions = representacions;
	}
	
	public List<Object> obteInformacio(Date data) {
		List<Object> rs = new ArrayList<Object>();
		
		for (Representacio r : representacions) {
			Date dataR = r.getData();
			if (data.equals(dataR)) {
				Object info = r.obteInformacio();
				rs.add(info);
			}
		}
		
		return null;
	}
}
