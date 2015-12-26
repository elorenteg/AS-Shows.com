package showscom.DomainLayer.domain_model;

import java.util.Date;

public class Estrena extends Representacio {
	private int recarrec;

	public Estrena(float preu, Date data, int nombreSeientsLliures) {
		super(preu, data, nombreSeientsLliures);
	}

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}
	
	public boolean esEstrena() {
		return true;
	}
}
