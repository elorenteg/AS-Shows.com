package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primaria d'un Seient en un Local per a una Representacio
 */
@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	// Fila del seient al local
	@Column(name = "fila")
	private int fila;
	// Columna del seient al local
	@Column(name = "columna")
	private int columna;
	// Nom del local del seient i de la representacio
	@Column(name = "nomL")
	private String nomLocal;
	// Sessio de la representacio
	@Column(name = "sessio")
	private String sessio;

	/**
	 * Constructora per defecte
	 */
	public SeientEnRepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzacio d'atributs
	 * @param fila fila del seient en representacio
	 * @param columna columna del seient en representacio
	 * @param nomLocal nom del local del seient en representacio i de la
	 *        representacio
	 * @param sessio sessio de la representacio
	 */
	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
	}
}
