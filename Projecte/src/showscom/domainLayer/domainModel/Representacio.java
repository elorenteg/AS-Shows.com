package showscom.domainLayer.domainModel;

import java.util.Date;

public class Representacio {
	private float preu;
	private Date data;
	private int nombreSeientsLliures;
	private Sessio sessio;
	private Local local;
	
	public Representacio(float preu, Date data, int nombreSeientsLliures) {
		super();
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;
	}
	
	public float getPreu() {
		return preu;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}
	
	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public Object obteInformacio() {
		Object tupla = null;
		
		String tipSessio = sessio.getSessio().toString();
		String nomLocal = local.getNom();
		boolean esEstrena = esEstrena();
		
		return tupla;
	}
	
	public boolean esEstrena() {
		return false;
	}

	public void reservarSeients(Object seients) {
		// TODO hacer mediante CtrlSeientsEnRepresentacio
		
	}
}
