package showscom.domainLayer.domainModel;

public enum Moneda {
	EUR("EUR",'€'), USD("USD",'$'), GBP("GBP",'£');

	private final String text;
	private final char symbol;

	private Moneda(final String text, final char symbol) {
		this.text = text;
		this.symbol = symbol;
	}
	
	public String getName() {
		return text;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public String toString() {
		return this.text + this.symbol;
	}
}
