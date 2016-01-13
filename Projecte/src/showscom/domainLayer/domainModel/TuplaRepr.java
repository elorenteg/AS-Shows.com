package showscom.domainLayer.domainModel;

/**
 * Classe auxiliar amb la informaci� d'una Representaci� que es vol mostrar
 */
public class TuplaRepr {
	// Sessi� de la representaci�
	private String sessio;
	// Nom del local de la representaci�
	private String local;
	// N�m. de seients lliures de la representaci�
	private int nombreSeientsLliures;
	// Si la representaci� �s una estrena
	private boolean esEstrena;
	// Preu base de la representaci�
	private float preu;
	// Rec�rrec de la representaci� per ser estrena
	private int recarrec;

	/**
	 * Consultora de la sessi�
	 * @return sessi� de la representaci�
	 */
	public String getSessio() {
		return sessio;
	}

	/**
	 * Modificadora de la sessi�
	 * @param sessio sessi� de la representaci�
	 */
	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

	/**
	 * Consultora del local de la representaci�
	 * @return nom del local de la representaci�
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Modificadora del local de la representaci�
	 * @param nomLocal nom del local de la representaci�
	 */
	public void setLocal(String nomLocal) {
		this.local = nomLocal;
	}

	/**
	 * Consultora del n�m. de seients lliures de la representaci�
	 * @return N�m. de seients lliure de la representaci� al local per aquella
	 *         sessi�
	 */
	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	/**
	 * Modificadora del n�m. de seients lliures de la representaci�
	 * @param nombreSeientsLliures N�m. de seients lliure de la representaci� al
	 *        local per aquella sessi�
	 */
	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	/**
	 * Consultora de si la representaci� �s una estrena
	 * @return si la representaci� �s una estrena
	 */
	public boolean getEsEstrena() {
		return esEstrena;
	}

	/**
	 * Modificadora de si la representaci� �s una estrena
	 * @param esEstrena si la representaci� �s una estrena
	 */
	public void setEsEstrena(boolean esEstrena) {
		this.esEstrena = esEstrena;
	}

	/**
	 * Consultora del preu de la representaci�
	 * @return preu base de la representaci�
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Modificadora del preu de la representaci�
	 * @param preu preu base de la representaci�
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

	/**
	 * Consultora del rec�rrec de la representaci�
	 * @return recr�rrec de la representaci� per ser estrena
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Modificadora del rec�rrec de la representaci�
	 * @param recarrec rec�rrec de la representaci� per ser estrena
	 */
	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

}
