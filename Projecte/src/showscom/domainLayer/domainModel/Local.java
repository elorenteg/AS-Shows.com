package showscom.domainLayer.domainModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Local")
public class Local {
	@Id
	@Column(name = "nom")
	private String nom;
	@Column(name = "adreca")
	private String adreca;
	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Representacio> representacions;
	@OneToMany(targetEntity = Seient.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Seient> seients;

	public Local() {
	}

	public Local(String nom, String adreca) {
		super();
		this.nom = nom;
		this.adreca = adreca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public List<Representacio> getRepresentacions() {
		return representacions;
	}

	public void setRepresentacions(List<Representacio> representacions) {
		this.representacions = representacions;
	}

	public List<Seient> getSeients() {
		return seients;
	}

	public void setSeients(List<Seient> seients) {
		this.seients = seients;
	}
}
