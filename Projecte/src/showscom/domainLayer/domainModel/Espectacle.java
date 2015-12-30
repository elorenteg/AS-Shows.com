package showscom.domainLayer.domainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Espectacle")
public class Espectacle {
	private String titol;
	private int participants;
	private List<Representacio> representacions;

	public Espectacle() {
	}

	public Espectacle(String titol, int participants) {
		super();
		this.titol = titol;
		this.participants = participants;
	}

	@Id
	@Column(name = "titol")
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	@Column(name = "participants")
	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "titolEspectacle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Representacio> getRepresentacions() {
		return representacions;
	}

	public void setRepresentacions(List<Representacio> representacions) {
		this.representacions = representacions;
	}

	public List<Object> obteInformacio(Date data) {
		List<Object> rs = new ArrayList<Object>();

		for (Representacio r : representacions) {
			Date dataR = r.getData();
			if (data.equals(dataR)) {
				Object info = r.obteInformacio();
				rs.add(info);
			}
		}

		return null;
	}
}
