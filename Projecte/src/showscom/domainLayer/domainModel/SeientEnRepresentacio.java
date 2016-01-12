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

@Entity
@Table(name = "SeientEnRepresentacio")
public class SeientEnRepresentacio {
	@Id
	@Embedded
	private SeientEnRepresentacioPK seientEnRepresentacioPK;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "nomL", referencedColumnName = "nomL", insertable = false, updatable = false),
			@JoinColumn(name = "fila", referencedColumnName = "fila", insertable = false, updatable = false),
			@JoinColumn(name = "columna", referencedColumnName = "columna", insertable = false, updatable = false) })
	private Seient seient;
	@Column(name = "estat")
	@Enumerated(EnumType.STRING)
	private Estat estat;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sessio", referencedColumnName = "sessio", insertable = false, updatable = false),
			@JoinColumn(name = "nomL", referencedColumnName = "nomL", insertable = false, updatable = false) })
	private Representacio representacio;
	@ManyToOne
	@JoinColumn(name = "idEnt", referencedColumnName = "idEnt")
	private Entrada entrada;

	public SeientEnRepresentacio() {
	}

	public SeientEnRepresentacio(Seient seient, Representacio representacio) {
		this.seientEnRepresentacioPK = new SeientEnRepresentacioPK(seient.getFila(), seient.getColumna(),
				representacio.getLocal().getNom(), representacio.getSessio().getSessio().name());
		this.seient = seient;
		this.representacio = representacio;
		this.estat = Estat.LLIURE;

	}

	public void ocupat(Entrada entrada) {
		this.entrada = entrada;
		this.estat = Estat.OCUPAT;
	}

	public TuplaSeient getPosicioSeient() {
		TuplaSeient tupla = new TuplaSeient();
		tupla.setFila(seient.getFila());
		tupla.setColumna(seient.getColumna());
		return tupla;
	}

	public boolean esSeientLliure() {
		return estat == Estat.LLIURE;
	}

}
