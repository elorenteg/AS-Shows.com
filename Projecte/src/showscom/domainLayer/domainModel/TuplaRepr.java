package showscom.domainLayer.domainModel;

/**
 * Classe auxiliar amb la informacio d'una Representacio que es vol mostrar
 */
public class TuplaRepr {
	// Sessio de la representacio
	private String sessio;
	// Nom del local de la representacio
	private String local;
	// Num. de seients lliures de la representacio
	private int nombreSeientsLliures;
	// Si la representacio es una estrena
	private boolean esEstrena;
	// Preu base de la representacio
	private float preu;
	// Recarrec de la representacio per ser estrena
	private int recarrec;

	/**
	 * Consultora de la sessio
	 * @return sessio de la representacio
	 */
	public String getSessio() {
		return sessio;
	}

	/**
	 * Modificadora de la sessio
	 * @param sessio sessio de la representacio
	 */
	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

	/**
	 * Consultora del local de la representacio
	 * @return nom del local de la representacio
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Modificadora del local de la representacio
	 * @param nomLocal nom del local de la representacio
	 */
	public void setLocal(String nomLocal) {
		this.local = nomLocal;
	}

	/**
	 * Consultora del num. de seients lliures de la representacio
	 * @return Num. de seients lliure de la representacio al local per aquella
	 *         sessio
	 */
	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	/**
	 * Modificadora del num. de seients lliures de la representacio
	 * @param nombreSeientsLliures Num. de seients lliure de la representacio al
	 *        local per aquella sessio
	 */
	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	/**
	 * Consultora de si la representacio es una estrena
	 * @return si la representacio es una estrena
	 */
	public boolean getEsEstrena() {
		return esEstrena;
	}

	/**
	 * Modificadora de si la representacio es una estrena
	 * @param esEstrena si la representacio es una estrena
	 */
	public void setEsEstrena(boolean esEstrena) {
		this.esEstrena = esEstrena;
	}

	/**
	 * Consultora del preu de la representacio
	 * @return preu base de la representacio
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Modificadora del preu de la representacio
	 * @param preu preu base de la representacio
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

	/**
	 * Consultora del recarrec de la representacio
	 * @return recrarrec de la representacio per ser estrena
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Modificadora del recarrec de la representacio
	 * @param recarrec recarrec de la representacio per ser estrena
	 */
	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

}
