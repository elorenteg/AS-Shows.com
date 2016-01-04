package showscom.domainLayer.domainModel;

import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "Entrada")
public class Entrada {
	// @Id
	private String identificador;
	// @Column(name="dniClient")
	private String dniClient;
	// @Column(name="nombreEspectadors")
	private int nombreEspectadors;
	// @Column(name="data")
	private Date data;
	// @Column(name = "preu")
	private float preu;
	// TODO indicar sólo guardamos sessio i nomLocal de representació
	private Representacio representacio;

	public Entrada(String identificador, String dni, int nombreEspectadors, Date dAvui, float preuTotal,
			Representacio r, List<TuplaSeient> seients) {
		super();
		this.identificador = identificador;
		dniClient = dni;
		this.nombreEspectadors = nombreEspectadors;
		this.data = dAvui;
		preu = preuTotal;
		representacio = r;
		representacio.reservarSeients(seients);
	}

}
