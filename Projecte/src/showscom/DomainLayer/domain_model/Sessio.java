package showscom.DomainLayer.domain_model;

public class Sessio {
	private TipusSessio sessio;

	public Sessio(TipusSessio sessio) {
		super();
		this.sessio = sessio;
	}

	public TipusSessio getSessio() {
		return sessio;
	}

	public void setSessio(TipusSessio sessio) {
		this.sessio = sessio;
	}
}