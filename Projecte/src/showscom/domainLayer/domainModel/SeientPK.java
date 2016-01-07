package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeientPK implements Serializable {

	@Column(name = "fila")
	private int fila;
	@Column(name = "columna")
	private int columna;
	@Column(name = "nomLocal")
	private String nomLocal;
	
	public SeientPK() {
		
	}

	public SeientPK(int fila, int columna, String nomLocal) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
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
}
