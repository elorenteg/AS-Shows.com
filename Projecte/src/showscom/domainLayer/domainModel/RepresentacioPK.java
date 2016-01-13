package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau prim�ria d'una Representaci�
 */
@Embeddable
public class RepresentacioPK implements Serializable {
	// Sessi� de la representaci�
	@Column(name = "sessio")
	String sessio;
	// Nom del local de la representaci�
	@Column(name = "nomL")
	String nomLocal;

	/**
	 * Constructora per defecte
	 */
	public RepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzaci� d'atributs
	 * @param sessio sessi� de la representaci�
	 * @param nomLocal nom del local de la representaci�
	 */
	public RepresentacioPK(String sessio, String nomLocal) {
		super();
		this.sessio = sessio;
		this.nomLocal = nomLocal;
	}
}
