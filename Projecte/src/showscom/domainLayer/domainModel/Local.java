package showscom.domainLayer.domainModel;

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

	private List<Representacio> representacions;

	public Local() {
	}

	public Local(String nom, String adreca) {
		super();
		this.nom = nom;
		this.adreca = adreca;
	}

	@Id
	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "adreca")
	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Representacio> getRepresentacions() {
		return representacions;
	}

	public void setRepresentacions(List<Representacio> representacions) {
		this.representacions = representacions;
	}

}
