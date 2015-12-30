package showscom.domainLayer.domainModel;

import java.util.Date;

public class Estrena extends Representacio {
	private int recarrec;

	public Estrena(Sessio sessio, Local local, float preu, Date data, int nombreSeientsLliures) {
		super(sessio, local, preu, data, nombreSeientsLliures);
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
