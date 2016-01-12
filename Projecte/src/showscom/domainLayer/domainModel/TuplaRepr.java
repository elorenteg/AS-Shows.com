package showscom.domainLayer.domainModel;

public class TuplaRepr {
	private String sessio;
	private String local;
	private int nombreSeientsLliures;
	private boolean esEstrena;
	private float preu;
	private int recarrec;

	public String getSessio() {
		return sessio;
	}

	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String nomLocal) {
		this.local = nomLocal;
	}

	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public boolean getEsEstrena() {
		return esEstrena;
	}

	public void setEsEstrena(boolean esEstrena) {
		this.esEstrena = esEstrena;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

}
