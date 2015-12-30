package showscom.domainLayer.domainModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Representacio")
public class Representacio {
	private float preu;
	private Date data;
	private int nombreSeientsLliures;
	private Sessio sessio;
	private Local local;

	private RepresentacioPK representacioPK;
	private String titolEspectacle;

	public Representacio() {
	}

	public Representacio(Sessio sessio, Local local, float preu, Date data, int nombreSeientsLliures) {
		super();
		this.sessio = sessio;
		this.local = local;
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;

		this.representacioPK = new RepresentacioPK(sessio.getSessio().name(), local.getNom());
	}

	@Column(name = "preu")
	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	@Column(name = "data")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "nSeientsLliures")
	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	@ManyToOne
	@JoinColumn(name = "sessio", referencedColumnName = "sessio")
	public Sessio getSessio() {
		return sessio;
	}

	public void setSessio(Sessio sessio) {
		this.sessio = sessio;
	}

	@ManyToOne
	@JoinColumn(name = "local", referencedColumnName = "nom")
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Id
	@Embedded
	public RepresentacioPK getRepresentacioPK() {
		return representacioPK;
	}

	public void setRepresentacioPK(RepresentacioPK representacioPK) {
		this.representacioPK = representacioPK;
	}

	@Column(name = "titolE")
	public String getTitolEspectacle() {
		return titolEspectacle;
	}

	public void setTitolEspectacle(String titolEspectacle) {
		this.titolEspectacle = titolEspectacle;
	}

	public Object obteInformacio() {
		Object tupla = null;

		String tipSessio = sessio.getSessio().toString();
		String nomLocal = local.getNom();
		boolean esEstrena = esEstrena();

		return tupla;
	}

	public boolean esEstrena() {
		return false;
	}

	public void reservarSeients(Object seients) {
		// TODO hacer mediante CtrlSeientsEnRepresentacio

	}
}
