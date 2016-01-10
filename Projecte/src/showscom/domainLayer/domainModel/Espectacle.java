package showscom.domainLayer.domainModel;

import java.io.Serializable;
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

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Espectacle")
@Check(constraints = "participants > 0")
public class Espectacle implements Serializable {
	@Id
	@Column(name = "titol")
	private String titol;
	@Column(name = "participants")
	private int participants;
	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "representacioPK.titolEspectacle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Representacio> representacions;

	public Espectacle() {
	}

	public Espectacle(String titol, int participants) {
		super();
		this.titol = titol;
		this.participants = participants;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public List<Representacio> getRepresentacions() {
		return representacions;
	}

	public void setRepresentacions(List<Representacio> representacions) {
		this.representacions = representacions;
	}

	public List<TuplaRepr> obteInformacio(Date data) {
		List<TuplaRepr> rs = new ArrayList<TuplaRepr>();

		for (Representacio r : representacions) {
			Date dataR = r.getData();
			if (data.equals(dataR)) {
				TuplaRepr info = r.obteInformacio();
				rs.add(info);
			}
		}

		return rs;
	}
}
