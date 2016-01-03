package showscom.domainLayer.domainModel;

public class SeientEnRepresentacio {
	private Seient seient;
	private Estat estat;
	
	public SeientEnRepresentacio(Seient seient, Estat estat) {
		super();
		this.seient = seient;
		this.estat = estat;
	}
	
	public SeientEnRepresentacio(Seient seient) {
		this.seient = seient;
		this.estat = Estat.LLIURE;
	}
	
	public int getFila() {
		return seient.getFila();
	}
	
	public int getColumna() {
		return seient.getColumna();
	}

	public Estat getEstat() {
		return estat;
	}

	public void ocupat() {
		this.estat = Estat.OCUPAT;
	}
	
	public TuplaSeientLl getSeient() {
		TuplaSeientLl tupla = new TuplaSeientLl();
		tupla.setFila(seient.getFila());
		tupla.setColumna(seient.getColumna());
		return tupla;		
	}

}
