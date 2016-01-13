package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Sessio")
@Check(constraints = "sessio IN ('MATI','TARDA','NIT')")
public class Sessio implements Serializable {
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