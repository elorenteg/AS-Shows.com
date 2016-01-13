package showscom.domainLayer.domainModel;

/**
 * Enumeracio de les possibles monedes en les que realitzar els pagaments
 */
public enum Moneda {
	EUR('€'), USD('$'), GBP('£');

	// Simbol de la moneda
	private final char symbol;

	/**
	 * Constructora de la Moneda amb el simbol
	 * @param symbol simbol de la moneda
	 */
	private Moneda(final char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Consultora del simbol de la moneda
	 * @return simbol de la moneda
	 */
	public char getSymbol() {
		return symbol;
	}
}
