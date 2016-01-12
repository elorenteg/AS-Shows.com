package showscom.domainLayer.domainModel;

public enum Moneda {
	EUR('€'), USD('$'), GBP('£');

	private final char symbol;

	private Moneda(final char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
}
