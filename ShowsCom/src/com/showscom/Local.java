package com.showscom;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Local")
public class Local {

	private String nom;
	private String adreca;
	private List<Seient> seients;

	@Id
	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "adreca", nullable = false)
	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	@Column(name = "seients", nullable = false)
	@OneToMany(targetEntity = Seient.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Seient> getSeients() {
		return seients;
	}

	public void setSeients(List<Seient> seients) {
		this.seients = seients;
	}
	
	public String toString() {
        String s = "  Nom: " + getNom() + "\n";
        s += "  Adreca: " + getAdreca() + "\n";
        
        int i = 1;
        for (Seient seient : seients) {
            s += "  " + "SEIENT " + i + "\n";
            s += "    " + "Fila " + seient.getSeientPK().getFila() + "\n";
            s += "    " + "Columna " + seient.getSeientPK().getColumna() + "\n";
            ++i;
        }
        
		return s;
	}
}
