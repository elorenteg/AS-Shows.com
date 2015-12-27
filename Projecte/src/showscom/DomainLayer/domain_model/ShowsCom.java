package showscom.DomainLayer.domain_model;

import java.util.List;

public class ShowsCom {
	private static ShowsCom instance = new ShowsCom();
	private int codiBanc;
	private String numeroCompte;
	private float comissio;
	private Moneda divisa;
	private List<Moneda> canvis;
	private int venudes;
	
	/* Un Constructor privat preve que una altra classe
	 * instancii la classe
	 */
	private ShowsCom() {}
	
	/* Metode estatic 'instance' */
	public static ShowsCom getInstance() {
		return instance;
	}

	public int getCodiBanc() {
		return codiBanc;
	}

	public void setCodiBanc(int codiBanc) {
		this.codiBanc = codiBanc;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public float getComissio() {
		return comissio;
	}

	public void setComissio(float comissio) {
		this.comissio = comissio;
	}

	public Moneda getDivisa() {
		return divisa;
	}

	public void setDivisa(Moneda divisa) {
		this.divisa = divisa;
	}

	public List<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(List<Moneda> canvis) {
		this.canvis = canvis;
	}
	
	public int incrementaVenudes() {
		return venudes++;
	}

	public static void setInstance(ShowsCom instance) {
		ShowsCom.instance = instance;
	}
}
