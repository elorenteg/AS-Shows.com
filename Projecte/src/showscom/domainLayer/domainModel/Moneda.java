package showscom.domainLayer.domainModel;

/**
 * Enumeraci� de les possibles monedes en les que realitzar els pagaments
 */
public enum Moneda {
	EUR('�'), USD('$'), GBP('�');

	// S�mbol de la moneda
	private final char symbol;

	/**
	 * Constructora de la Moneda amb el s�mbol
	 * @param symbol s�mbol de la moneda
	 */
	private Moneda(final char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Consultora del s�mbol de la moneda
	 * @return s�mbol de la moneda
	 */
	public char getSymbol() {
		return symbol;
	}
}
