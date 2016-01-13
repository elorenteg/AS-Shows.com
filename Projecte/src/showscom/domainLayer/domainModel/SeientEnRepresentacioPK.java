package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau prim�ria d'un Seient en un Local per a una Representaci�
 */
@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	// Fila del seient al local
	@Column(name = "fila")
	private int fila;
	// Columna del seient al local
	@Column(name = "columna")
	private int columna;
	// Nom del local del seient i de la representaci�
	@Column(name = "nomL")
	private String nomLocal;
	// Sessi� de la representaci�
	@Column(name = "sessio")
	private String sessio;

	/**
	 * Constructora per defecte
	 */
	public SeientEnRepresentacioPK() {
	}

	/**
	 * Constructora amb inicialitzaci� d'atributs
	 * @param fila fila del seient en representaci�
	 * @param columna columna del seient en representaci�
	 * @param nomLocal nom del local del seient en representaci� i de la
	 *        representaci�
	 * @param sessio sessi� de la representaci�
	 */
	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
	}
}
