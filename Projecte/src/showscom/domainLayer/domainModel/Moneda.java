package showscom.domainLayer.domainModel;

/**
 * Enumeració de les possibles monedes en les que realitzar els pagaments
 */
public enum Moneda {
	EUR('€'), USD('$'), GBP('£');

	// Símbol de la moneda
	private final char symbol;

	/**
	 * Constructora de la Moneda amb el símbol
	 * @param symbol símbol de la moneda
	 */
	private Moneda(final char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Consultora del símbol de la moneda
	 * @return símbol de la moneda
	 */
	public char getSymbol() {
		return symbol;
	}
}
