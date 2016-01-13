package showscom.domainLayer.domainModel;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representaci� d'un Seient en un Local per a una Representaci�
 */
@Entity
@Table(name = "SeientEnRepresentacio")
@Check(constraints = "estat IN ('LLIURE','OCUPAT')")
public class SeientEnRepresentacio {
	// Identificador del seient de la representaci�
	@Id
	@Embedded
	private SeientEnRepresentacioPK seientEnRepresentacioPK;
	// Seient corresponent al local
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "nomL", referencedColumnName = "nomL", insertable = false, updatable = false),
			@JoinColumn(name = "fila", referencedColumnName = "fila", insertable = false, updatable = false),
			@JoinColumn(name = "columna", referencedColumnName = "columna", insertable = false, updatable = false) })
	private Seient seient;
	// Estat del seient per a la representaci�
	@Column(name = "estat")
	@Enumerated(EnumType.STRING)
	private Estat estat;
	// Representaci� del seient en representaci�
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sessio", referencedColumnName = "sessio", insertable = false, updatable = false),
			@JoinColumn(name = "nomL", referencedColumnName = "nomL", insertable = false, updatable = false) })
	private Representacio representacio;
	// Entrada del seient en representaci�
	@ManyToOne
	@JoinColumn(name = "idEnt", referencedColumnName = "idEnt")
	private Entrada entrada;

	/**
	 * Constructora per defecte
	 */
	public SeientEnRepresentacio() {
	}

	/**
	 * Constructora amb inicialitzaci� d'atributs
	 * @param seient seient corresponent en el local
	 * @param representacio representaci� del seient en representaci�
	 */
	public SeientEnRepresentacio(Seient seient, Representacio representacio) {
		this.seientEnRepresentacioPK = new SeientEnRepresentacioPK(seient.getFila(), seient.getColumna(),
				representacio.getLocal().getNom(), representacio.getSessio().getSessio().name());
		this.seient = seient;
		this.representacio = representacio;
		this.estat = Estat.LLIURE;

	}

	/**
	 * Actualitza l'estat del seient per la representaci� a ocupat i assigna una
	 * entrada al seient en representaci�
	 * @param entrada entrada associada
	 */
	public void ocupat(Entrada entrada) {
		this.entrada = entrada;
		this.estat = Estat.OCUPAT;
	}

	/**
	 * Obt� la posici� del seient al local
	 * @return Tupla amb la fila i columna del seient al local
	 */
	public TuplaSeient getPosicioSeient() {
		TuplaSeient tupla = new TuplaSeient();
		tupla.setFila(seient.getFila());
		tupla.setColumna(seient.getColumna());
		return tupla;
	}

	/**
	 * Comproca si �s un seient en representaci� lliure
	 * @return retorna si el seu estat �s lliure
	 */
	public boolean esSeientLliure() {
		return estat == Estat.LLIURE;
	}

}
