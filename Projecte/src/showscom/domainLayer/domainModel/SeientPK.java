package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa la clau primària d'un Seient en un Local
 */
@Embeddable
public class SeientPK implements Serializable {
	// Fila del seient al local
	@Column(name = "fila")
	private int fila;
	// Columna del seient al local
	@Column(name = "columna")
	private int columna;
	// Nom del local del seient
	@Column(name = "nomL")
	private String nomLocal;

	/**
	 * Constructora per defecte
	 */
	public SeientPK() {
	}

	/**
	 * Constructora amb inicialització d'atributs
	 * @param fila fila del seient
	 * @param columna columna del seient
	 * @param nomLocal nom del local del seient
	 */
	public SeientPK(int fila, int columna, String nomLocal) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
	}

	/**
	 * Consultora de la fila del seient en el local
	 * @return fila del seient en el local
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Consultora de la columna del seient en el local
	 * @return columna del seient en el local
	 */
	public int getColumna() {
		return columna;
	}
}
