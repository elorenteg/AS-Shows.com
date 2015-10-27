package com.showscom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Check;

@Embeddable
public class SeientPK implements Serializable {

	private int fila;
	private int columna;
	private String nomLocal;
	
	public SeientPK() {
		
	}

	public SeientPK(int fila, int columna, String nomLocal) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.nomLocal = nomLocal;
	}

	@Column(name = "fila")
	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	@Column(name = "columna")
	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	@Column(name = "nomLocal")
	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}
}
