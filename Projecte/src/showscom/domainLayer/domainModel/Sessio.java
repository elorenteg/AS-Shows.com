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
 * Representació d'un Sessió
 */
@Entity
@Table(name = "Sessio")
@Check(constraints = "sessio IN ('MATI','TARDA','NIT')")
public class Sessio implements Serializable {
	// Tipus de sessió de la sessió
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
	 * Constructora amb inicialització d'atributs
	 * @param sessio tipus de sessió de la sessió
	 */
	public Sessio(TipusSessio sessio) {
		super();
		this.sessio = sessio;
	}

	/**
	 * Consultora del tipus de sessió
	 * @return tipus de sessió de la sessió
	 */
	public TipusSessio getSessio() {
		return sessio;
	}
}