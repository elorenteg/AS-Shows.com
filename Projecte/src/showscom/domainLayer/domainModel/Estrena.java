package showscom.domainLayer.domainModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representació d'una Estrena d'una Representació
 */
@Entity
@Table(name = "Estrena")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "nomL"), @PrimaryKeyJoinColumn(name = "sessio") })
@Check(constraints = "recarrec > 0")
public class Estrena extends Representacio {
	// Recàrrec extra en el preu per ser estrena
	@Column(name = "recarrec")
	private int recarrec;

	/**
	 * Constructor per defecte
	 */
	public Estrena() {
	}

	/**
	 * Constructor amb inicialització d'atributs
	 * @param sessio sessió de la representació
	 * @param local local de la representació
	 * @param titolE títol de l'espectacle
	 * @param preu preu base de la representació
	 * @param data data de la representació
	 * @param nombreSeientsLliures núm. de seients lliures de la representació
	 * @param recarrec recàrrec extra per ser estrena
	 */
	public Estrena(Sessio sessio, Local local, String titolE, float preu, Date data, int nombreSeientsLliures,
			int recarrec) {
		super(sessio, local, titolE, preu, data, nombreSeientsLliures);
		this.recarrec = recarrec;
	}

	/**
	 * Consultora del recàrrec
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Comprova si és una Estrena
	 * @return retorna que és una Estrena
	 */
	public boolean esEstrena() {
		return true;
	}
}
