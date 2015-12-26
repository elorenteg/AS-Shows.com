package showscom.DomainLayer.domain_model;

public enum TipusSessio {
	MATI ("mati"),
	TARDA ("tarda"),
	NIT ("nit");
	
	private final String text;
	
	private TipusSessio(final String text) {
		this.text = text;
	}
	
	public String toString() {
		return this.text;
	}
}
