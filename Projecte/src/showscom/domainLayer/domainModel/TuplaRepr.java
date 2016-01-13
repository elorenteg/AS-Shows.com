package showscom.domainLayer.domainModel;

/**
 * Classe auxiliar amb la informació d'una Representació que es vol mostrar
 */
public class TuplaRepr {
	// Sessió de la representació
	private String sessio;
	// Nom del local de la representació
	private String local;
	// Núm. de seients lliures de la representació
	private int nombreSeientsLliures;
	// Si la representació és una estrena
	private boolean esEstrena;
	// Preu base de la representació
	private float preu;
	// Recàrrec de la representació per ser estrena
	private int recarrec;

	/**
	 * Consultora de la sessió
	 * @return sessió de la representació
	 */
	public String getSessio() {
		return sessio;
	}

	/**
	 * Modificadora de la sessió
	 * @param sessio sessió de la representació
	 */
	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

	/**
	 * Consultora del local de la representació
	 * @return nom del local de la representació
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Modificadora del local de la representació
	 * @param nomLocal nom del local de la representació
	 */
	public void setLocal(String nomLocal) {
		this.local = nomLocal;
	}

	/**
	 * Consultora del núm. de seients lliures de la representació
	 * @return Núm. de seients lliure de la representació al local per aquella
	 *         sessió
	 */
	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	/**
	 * Modificadora del núm. de seients lliures de la representació
	 * @param nombreSeientsLliures Núm. de seients lliure de la representació al
	 *        local per aquella sessió
	 */
	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	/**
	 * Consultora de si la representació és una estrena
	 * @return si la representació és una estrena
	 */
	public boolean getEsEstrena() {
		return esEstrena;
	}

	/**
	 * Modificadora de si la representació és una estrena
	 * @param esEstrena si la representació és una estrena
	 */
	public void setEsEstrena(boolean esEstrena) {
		this.esEstrena = esEstrena;
	}

	/**
	 * Consultora del preu de la representació
	 * @return preu base de la representació
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Modificadora del preu de la representació
	 * @param preu preu base de la representació
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

	/**
	 * Consultora del recàrrec de la representació
	 * @return recràrrec de la representació per ser estrena
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Modificadora del recàrrec de la representació
	 * @param recarrec recàrrec de la representació per ser estrena
	 */
	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

}
