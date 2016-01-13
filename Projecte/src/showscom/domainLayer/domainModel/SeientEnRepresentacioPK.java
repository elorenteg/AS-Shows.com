package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primāria d'un Seient en un Local per a una Representaciķ
 */
@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	// Fila del seient al local
	@Column(name = "fila")
	private int fila;
	// Columna del seient al local
	@Column(name = "columna")
	private int columna;
	// Nom del local del seient i de la representaciķ
	@Column(name = "nomL")
	private String nomLocal;
	// Sessiķ de la representaciķ
	@Column(name = "sessio")
	private String sessio;

	/**
	 * Constructora per defecte
	 */
	public SeientEnRepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzaciķ d'atributs
	 * @param fila fila del seient en representaciķ
	 * @param columna columna del seient en representaciķ
	 * @param nomLocal nom del local del seient en representaciķ i de la
	 *        representaciķ
	 * @param sessio sessiķ de la representaciķ
	 */
	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
	}
}
