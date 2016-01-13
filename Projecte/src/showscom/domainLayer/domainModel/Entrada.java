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

/**
 * Representacio d'una Entrada a comprar
 */
@Entity
@Table(name = "Entrada")
@Check(constraints = "preu > 0 AND nEspectadors > 0")
public class Entrada {
	// Identificador de l'Entrada
	@Id
	@Column(name = "idEnt")
	private String identificador;
	// DNI del client que compra l'entrada
	@Column(name = "dniClient")
	private String dniClient;
	// Num. d'espectadors de l'entrada
	@Column(name = "nEspectadors")
	private int nombreEspectadors;
	// Data de compra de l'entrada
	@Column(name = "data")
	private Date data;
	// Preu total de l'entrada
	@Column(name = "preu")
	private float preu;
	// Representacio de l'entrada
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "sessio", referencedColumnName = "sessio"),
			@JoinColumn(name = "nomL", referencedColumnName = "nomL") })
	private Representacio representacio;

	/**
	 * Constructor per defecte
	 */
	public Entrada() {
	}

	/**
	 * Constructor amb inicialitzacio d'atributs
	 * @param identificador identificador de l'entrada
	 * @param dni DNI del client que compra l'entrada
	 * @param nombreEspectadors num. d'espectadors de l'entrada
	 * @param dAvui data de la compra de l'entrada
	 * @param preuTotal preu total de l'entrada
	 * @param r representacio de l'entrada
	 * @param seients seients que volen comprar
	 */
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
