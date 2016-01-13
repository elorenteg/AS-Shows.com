package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primària d'una Representació
 */
@Embeddable
public class RepresentacioPK implements Serializable {
	// Sessió de la representació
	@Column(name = "sessio")
	String sessio;
	// Nom del local de la representació
	@Column(name = "nomL")
	String nomLocal;

	/**
	 * Constructora per defecte
	 */
	public RepresentacioPK() {
	}

	/**
	 * Constructora amb inicialització d'atributs
	 * @param sessio sessió de la representació
	 * @param nomLocal nom del local de la representació
	 */
	public RepresentacioPK(String sessio, String nomLocal) {
		super();
		this.sessio = sessio;
		this.nomLocal = nomLocal;
	}
}
