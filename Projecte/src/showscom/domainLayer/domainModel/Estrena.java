package showscom.domainLayer.domainModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representacio d'una Estrena d'una Representacio
 */
@Entity
@Table(name = "Estrena")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "nomL"), @PrimaryKeyJoinColumn(name = "sessio") })
@Check(constraints = "recarrec > 0")
public class Estrena extends Representacio {
	// Recarrec extra en el preu per ser estrena
	@Column(name = "recarrec")
	private int recarrec;

	/**
	 * Constructor per defecte
	 */
	public Estrena() {
	}

	/**
	 * Constructor amb inicialitzacio d'atributs
	 * @param sessio sessio de la representacio
	 * @param local local de la representacio
	 * @param titolE titol de l'espectacle
	 * @param preu preu base de la representacio
	 * @param data data de la representacio
	 * @param nombreSeientsLliures num. de seients lliures de la representacio
	 * @param recarrec recarrec extra per ser estrena
	 */
	public Estrena(Sessio sessio, Local local, String titolE, float preu, Date data, int nombreSeientsLliures,
			int recarrec) {
		super(sessio, local, titolE, preu, data, nombreSeientsLliures);
		this.recarrec = recarrec;
	}

	/**
	 * Consultora del recarrec
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Comprova si es una Estrena
	 * @return retorna que es una Estrena
	 */
	public boolean esEstrena() {
		return true;
	}
}
