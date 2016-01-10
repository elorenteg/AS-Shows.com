package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

	public SeientEnRepresentacioPK() {
	}

	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
		this.sessio = sessio;
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
}
