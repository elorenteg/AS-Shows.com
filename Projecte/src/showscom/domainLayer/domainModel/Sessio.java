package showscom.domainLayer.domainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sessio")
public class Sessio {
	@Id
	@Column(name = "sessio")
	@Enumerated(EnumType.STRING)
	private TipusSessio sessio;

	public Sessio() {
	}

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