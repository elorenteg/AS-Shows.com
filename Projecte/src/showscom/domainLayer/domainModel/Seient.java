package showscom.domainLayer.domainModel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representacio d'un Seient d'un Local
 */
@Entity
@Table(name = "Seient")
@Check(constraints = "fila > 0 AND columna > 0")
public class Seient {
	// Identificador del seient
	@Id
	@Embedded
	private SeientPK seientPK;
	// Local del seient
	@ManyToOne
	@JoinColumn(name = "nomL", referencedColumnName = "nom", insertable = false, updatable = false)
	private Local local;

	/**
	 * Constructor per defecte
	 */
	public Seient() {
	}

	/**
	 * Constructor amb inicialitzacio d'atributs
	 * @param fila fila del seient al local
	 * @param columna columna del seient al local
	 * @param local local del seient
	 */
	public Seient(int fila, int columna, Local local) {
		seientPK = new SeientPK(fila, columna, local.getNom());
		this.local = local;
	}

	/**
	 * Consultora de la fila del seient al local
	 * @return fila del seient al local
	 */
	public int getFila() {
		return seientPK.getFila();
	}

	/**
	 * Consultora de la columna del seient al local
	 * @return columna del seient al local
	 */
	public int getColumna() {
		return seientPK.getColumna();
	}
}
