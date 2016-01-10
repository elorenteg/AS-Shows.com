package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	@Column(name = "fila")
	private int fila;
	@Column(name = "columna")
	private int columna;
	@Column(name = "nomL")
	private String nomLocal;
	@Column(name = "sessio")
	private String sessio;
	// @Column(name = "titolE")
	// private String titolE;

	/*
	 * @JoinColumns({ @JoinColumn(name = "fila", referencedColumnName = "fila"),
	 * 
	 * @JoinColumn(name = "columna", referencedColumnName = "columna"),
	 * 
	 * @JoinColumn(name = "nomL", referencedColumnName = "nomLocal") }) private
	 * SeientPK seientPK;
	 * 
	 * @JoinColumns({ @JoinColumn(name = "sessio", referencedColumnName =
	 * "sessio"),
	 * 
	 * @JoinColumn(name = "nomL", referencedColumnName = "nomL"),
	 * 
	 * @JoinColumn(name = "titolE", referencedColumnName = "titolE") }) private
	 * RepresentacioPK representacioPK;
	 */

	public SeientEnRepresentacioPK() {
	}

	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
	}

	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio, String titolE) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		// this.titolE = titolE;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public String getSessio() {
		return sessio;
	}

	public void setSessio(String sessio) {
		this.sessio = sessio;
	}
	/*
	 * 
	 * public String getTitolE() { return titolE; }
	 * 
	 * public void setTitolE(String titolE) { this.titolE = titolE; }
	 */

	/*
	 * public SeientEnRepresentacioPK(int fila, int columna, String nomLocal,
	 * String sessio, String titolE) { super(); this.seientPK = new
	 * SeientPK(fila, columna, nomLocal); this.representacioPK = new
	 * RepresentacioPK(sessio, nomLocal, titolE); }
	 * 
	 * public SeientPK getSeientPK() { return seientPK; }
	 * 
	 * public void setSeientPK(SeientPK seientPK) { this.seientPK = seientPK; }
	 * 
	 * public int getFila() { return seientPK.getFila(); }
	 * 
	 * public void setFila(int fila) { seientPK.setFila(fila); }
	 * 
	 * public int getColumna() { return seientPK.getColumna(); }
	 * 
	 * public void setColumna(int columna) { seientPK.setColumna(columna); }
	 * 
	 * public String getNomLocal() { return seientPK.getNomLocal(); }
	 * 
	 * public void setNomLocal(String nomLocal) {
	 * seientPK.setNomLocal(nomLocal); }
	 * 
	 * public RepresentacioPK getRepresentacioPK() { return representacioPK; }
	 * 
	 * public void setRepresentacioPK(RepresentacioPK representacioPK) {
	 * this.representacioPK = representacioPK; }
	 */

}
