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
	@JoinColumns({ @JoinColumn(name = "nomLSEIENT_REPR", referencedColumnName = "nomLocal"),
			@JoinColumn(name = "filaSEIENT_REPR", referencedColumnName = "fila"),
			@JoinColumn(name = "columnaSEIENT_REPR", referencedColumnName = "columna") })
	private Seient seient;
	@Column(name = "estat")
	@Enumerated(EnumType.STRING)
	private Estat estat;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sessioSEIENT_REPR", referencedColumnName = "sessio"),
			@JoinColumn(name = "nomL", referencedColumnName = "nomL"),
			@JoinColumn(name = "titolE", referencedColumnName = "titolE") })
	private Representacio representacio;
	@ManyToOne
	@JoinColumn(name = "idEnt", referencedColumnName = "idEnt", insertable = false, updatable = false)
	private Entrada entrada;

	public SeientEnRepresentacio() {
		super();
	}

	public SeientEnRepresentacio(Seient seient, Estat estat) {
		super();
		this.seient = seient;
		this.estat = estat;
	}

	public SeientEnRepresentacio(Seient seient) {
		this.seient = seient;
		this.estat = Estat.LLIURE;
	}

	public int getFila() {
		return seient.getFila();
	}

	public int getColumna() {
		return seient.getColumna();
	}

	public Estat getEstat() {
		return estat;
	}

	public void ocupat() {
		this.estat = Estat.OCUPAT;
	}

	public TuplaSeient getSeient() {
		TuplaSeient tupla = new TuplaSeient();
		tupla.setFila(seient.getFila());
		tupla.setColumna(seient.getColumna());
		return tupla;
	}

}
