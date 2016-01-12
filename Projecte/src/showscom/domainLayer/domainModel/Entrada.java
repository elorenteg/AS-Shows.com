package showscom.domainLayer.domainModel;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import showscom.domainLayer.dataInterface.ICtrlEntrada;
import showscom.domainLayer.factories.CtrlDataFactory;

@Entity
@Table(name = "Entrada")
@Check(constraints = "preu > 0 AND nEspectadors > 0")
public class Entrada {
	@Id
	@Column(name = "idEnt")
	private String identificador;
	@Column(name = "dniClient")
	private String dniClient;
	@Column(name = "nEspectadors")
	private int nombreEspectadors;
	@Column(name = "data")
	private Date data;
	@Column(name = "preu")
	private float preu;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sessio", referencedColumnName = "sessio"),
			@JoinColumn(name = "nomL", referencedColumnName = "nomL") })
	private Representacio representacio;

	public Entrada() {
	}

	public Entrada(String identificador, String dni, int nombreEspectadors, Date dAvui, float preuTotal,
			Representacio r, List<TuplaSeient> seients) {
		super();
		this.identificador = identificador;
		this.dniClient = dni;
		this.nombreEspectadors = nombreEspectadors;
		this.data = dAvui;
		this.preu = preuTotal;
		this.representacio = r;

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlEntrada ctrlEnt = ctrlDataFact.getCtrlEntrada();
		ctrlEnt.insertEntrada(this);

		representacio.reservarSeients(seients, this);
	}

}
