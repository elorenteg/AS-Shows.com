package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primāria d'una Representaciķ
 */
@Embeddable
public class RepresentacioPK implements Serializable {
	// Sessiķ de la representaciķ
	@Column(name = "sessio")
	String sessio;
	// Nom del local de la representaciķ
	@Column(name = "nomL")
	String nomLocal;

	/**
	 * Constructora per defecte
	 */
	public RepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzaciķ d'atributs
	 * @param sessio sessiķ de la representaciķ
	 * @param nomLocal nom del local de la representaciķ
	 */
	public RepresentacioPK(String sessio, String nomLocal) {
		super();
		this.sessio = sessio;
		this.nomLocal = nomLocal;
	}
}
