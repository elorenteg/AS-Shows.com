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
 * Representaci� d'un Sessi�
 */
@Entity
@Table(name = "Sessio")
@Check(constraints = "sessio IN ('MATI','TARDA','NIT')")
public class Sessio implements Serializable {
	// Tipus de sessi� de la sessi�
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
	 * Constructora amb inicialitzaci� d'atributs
	 * @param sessio tipus de sessi� de la sessi�
	 */
	public Sessio(TipusSessio sessio) {
		super();
		this.sessio = sessio;
	}

	/**
	 * Consultora del tipus de sessi�
	 * @return tipus de sessi� de la sessi�
	 */
	public TipusSessio getSessio() {
		return sessio;
	}
}