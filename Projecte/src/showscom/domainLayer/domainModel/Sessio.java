package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representacio d'un Sessio
 */
@Entity
@Table(name = "Sessio")
@Check(constraints = "sessio IN ('MATI','TARDA','NIT')")
public class Sessio implements Serializable {
	// Tipus de sessio de la sessio
	@Id
	@Column(name = "sessio")
	@Enumerated(EnumType.STRING)
	private TipusSessio sessio;

	/**
	 * Constructora per defecte
	 */
	public Sessio() {
	}

	/**
	 * Constructora amb inicialitzacio d'atributs
	 * @param sessio tipus de sessio de la sessio
	 */
	public Sessio(TipusSessio sessio) {
		super();
		this.sessio = sessio;
	}

	/**
	 * Consultora del tipus de sessio
	 * @return tipus de sessio de la sessio
	 */
	public TipusSessio getSessio() {
		return sessio;
	}
}