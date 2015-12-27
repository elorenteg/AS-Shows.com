package showscom.DomainLayer.domain_model;

import java.util.Date;

public class Entrada {
	private String identificador;
	private String dniClient;
	private int nombreEspectadors;
	private Date data;
	private float preu;
	private Representacio representacio;
	
	public Entrada(String identificador, String dni, int nombreEspectadors, Date dAvui, float preuTotal, Representacio r, Object seients) {
		super();
		this.identificador = identificador;
		dniClient = dni;
		this.nombreEspectadors = nombreEspectadors;
		this.data = dAvui;
		preu = preuTotal;
		representacio = r;
		representacio.reservarSeients(seients);
		// TODO seients type 
	}
	
	
}
