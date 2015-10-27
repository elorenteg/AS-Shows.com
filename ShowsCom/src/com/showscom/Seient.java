package com.showscom;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seient")
public class Seient {

	private SeientPK seientPK;
	private Local local;
	
	@Id
	@Embedded
	public SeientPK getSeientPK() {
		return seientPK;
	}

	public void setSeientPK(SeientPK seientPK) {
		this.seientPK = seientPK;
	}

	@ManyToOne
	@JoinColumn(name = "local", referencedColumnName = "nom")
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public String toString() {
        String s = "  Fila: " + getSeientPK().getFila() + "\n";
        s += "  Columna: " + getSeientPK().getFila() + "\n";
        s += "  Local: " + getSeientPK().getNomLocal() + "\n";
		return s;
	}
}
