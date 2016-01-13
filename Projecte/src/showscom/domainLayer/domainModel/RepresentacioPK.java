package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primaria d'una Representacio
 */
@Embeddable
public class RepresentacioPK implements Serializable {
	// Sessio de la representacio
	@Column(name = "sessio")
	String sessio;
	// Nom del local de la representacio
	@Column(name = "nomL")
	String nomLocal;

	/**
	 * Constructora per defecte
	 */
	public RepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzacio d'atributs
	 * @param sessio sessio de la representacio
	 * @param nomLocal nom del local de la representacio
	 */
	public RepresentacioPK(String sessio, String nomLocal) {
		super();
		this.sessio = sessio;
		this.nomLocal = nomLocal;
	}
}
