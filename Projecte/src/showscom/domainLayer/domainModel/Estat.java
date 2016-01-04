package showscom.domainLayer.domainModel;

public enum Estat {
	LLIURE("lliure"), OCUPAT("ocupat");

	private final String text;

	private Estat(final String text) {
		this.text = text;
	}

	public String toString() {
		return this.text;
	}
}
