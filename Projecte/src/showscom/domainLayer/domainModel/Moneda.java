package showscom.domainLayer.domainModel;

public enum Moneda {
	EUR("EUR"), USD("USD"), GBP("GBP");

	private final String text;

	private Moneda(final String text) {
		this.text = text;
	}

	public String toString() {
		return this.text;
	}
}
