package showscom.domainLayer.domainModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representaci� d'una Estrena d'una Representaci�
 */
@Entity
@Table(name = "Estrena")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "nomL"), @PrimaryKeyJoinColumn(name = "sessio") })
@Check(constraints = "recarrec > 0")
public class Estrena extends Representacio {
	// Rec�rrec extra en el preu per ser estrena
	@Column(name = "recarrec")
	private int recarrec;

	/**
	 * Constructor per defecte
	 */
	public Estrena() {
	}

	/**
	 * Constructor amb inicialitzaci� d'atributs
	 * @param sessio sessi� de la representaci�
	 * @param local local de la representaci�
	 * @param titolE t�tol de l'espectacle
	 * @param preu preu base de la representaci�
	 * @param data data de la representaci�
	 * @param nombreSeientsLliures n�m. de seients lliures de la representaci�
	 * @param recarrec rec�rrec extra per ser estrena
	 */
	public Estrena(Sessio sessio, Local local, String titolE, float preu, Date data, int nombreSeientsLliures,
			int recarrec) {
		super(sessio, local, titolE, preu, data, nombreSeientsLliures);
		this.recarrec = recarrec;
	}

	/**
	 * Consultora del rec�rrec
	 */
	public int getRecarrec() {
		return recarrec;
	}

	/**
	 * Comprova si �s una Estrena
	 * @return retorna que �s una Estrena
	 */
	public boolean esEstrena() {
		return true;
	}
}
