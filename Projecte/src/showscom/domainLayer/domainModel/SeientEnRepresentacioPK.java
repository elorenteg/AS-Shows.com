package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primària d'un Seient en un Local per a una Representació
 */
@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	// Fila del seient al local
	@Column(name = "fila")
	private int fila;
	// Columna del seient al local
	@Column(name = "columna")
	private int columna;
	// Nom del local del seient i de la representació
	@Column(name = "nomL")
	private String nomLocal;
	// Sessió de la representació
	@Column(name = "sessio")
	private String sessio;

	/**
	 * Constructora per defecte
	 */
	public SeientEnRepresentacioPK() {
	}

	/**
	 * Constructora amb inicialització d'atributs
	 * @param fila fila del seient en representació
	 * @param columna columna del seient en representació
	 * @param nomLocal nom del local del seient en representació i de la
	 *        representació
	 * @param sessio sessió de la representació
	 */
	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
	}
}
