package showscom.domainLayer.domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import showscom.domainLayer.exceptions.DOSeientsNoDisp;

@Entity
@Table(name = "Representacio", uniqueConstraints = @UniqueConstraint(columnNames = { "sessio", "nomL" }) )
@Inheritance(strategy = InheritanceType.JOINED)
@Check(constraints = "preu > 0 AND nSeientsLliures >= 0")
public class Representacio implements Serializable {
	@Id
	@Embedded
	private RepresentacioPK representacioPK;
	@Column(name = "titolE")
	private String titolE;
	@Column(name = "preu")
	private float preu;
	@Column(name = "data")
	private Date data;
	@Column(name = "nSeientsLliures")
	private int nombreSeientsLliures;
	@ManyToOne
	@JoinColumn(name = "sessio", referencedColumnName = "sessio", insertable = false, updatable = false)
	private Sessio sessio;
	@ManyToOne
	@JoinColumn(name = "nomL", referencedColumnName = "nom", insertable = false, updatable = false)
	private Local local;
	@OneToMany(targetEntity = SeientEnRepresentacio.class, mappedBy = "representacio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SeientEnRepresentacio> seientsEnRepresentacio;

	public Representacio() {
	}

	public Representacio(Sessio sessio, Local local, String titolEsp, float preu, Date data, int nombreSeientsLliures) {
		super();
		this.sessio = sessio;
		this.local = local;
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;

		this.representacioPK = new RepresentacioPK(sessio.getSessio().name(), local.getNom());
		this.titolE = titolEsp;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public Sessio getSessio() {
		return sessio;
	}

	public void setSessio(Sessio sessio) {
		this.sessio = sessio;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public RepresentacioPK getRepresentacioPK() {
		return representacioPK;
	}

	public void setRepresentacioPK(RepresentacioPK representacioPK) {
		this.representacioPK = representacioPK;
	}

	public String getTitolE() {
		return titolE;
	}

	public void setTitolE(String titolE) {
		this.titolE = titolE;
	}

	public List<SeientEnRepresentacio> getSeientsEnRepresentacio() {
		return seientsEnRepresentacio;
	}

	public void setSeientsEnRepresentacio(List<SeientEnRepresentacio> seientsEnRepresentacio) {
		this.seientsEnRepresentacio = seientsEnRepresentacio;
	}

	public String toString() {
		String s = "";
		s += "PK.sessio: " + representacioPK.getSessio() + "\n";
		s += "PK.local: " + representacioPK.getNomLocal() + "\n";
		// s += "PK.espectacle: " + representacioPK.getTitolEspectacle() + "\n";
		s += "PK.espectacle: " + getTitolE() + "\n";
		s += "sessio: " + getSessio().getSessio().name() + "\n";
		s += "local: " + getLocal().getNom() + "\n";
		s += "preu: " + getPreu() + "\n";
		s += "data: " + getData() + "\n";
		s += "nSeientsLliures: " + getNombreSeientsLliures() + "\n";
		return s;
	}

	public TuplaRepr obteInformacio() {
		TuplaRepr tupla = new TuplaRepr();

		tupla.setSessio(sessio.getSessio().name());
		tupla.setLocal(local.getNom());
		tupla.setNombreSeientsLliures(nombreSeientsLliures);
		tupla.setEsEstrena(esEstrena());
		tupla.setPreu(preu);

		return tupla;
	}

	public boolean esEstrena() {
		return false;
	}

	public void reservarSeients(List<TuplaSeient> seients) {
		// TODO hacer mediante CtrlSeientsEnRepresentacio
		String nom = this.local.getNom();
		TipusSessio sessio = this.sessio.getSessio();
		for (TuplaSeient aux : seients) {
			// SeientEnRepresentacio seient = obte (nom, sessio, aux.getFila(),
			// aux.getColumna());
			// seient.ocupat();
		}

	}

	public List<TuplaSeient> obteSeientsLliures(int nombreEspectadors) throws DOSeientsNoDisp {
		if (this.nombreSeientsLliures < nombreEspectadors)
			throw new DOSeientsNoDisp();

		List<TuplaSeient> oc = new ArrayList<>();

		for (SeientEnRepresentacio seient : seientsEnRepresentacio) {
			if (seient.esSeientLliure()) {
				TuplaSeient tupla = new TuplaSeient();
				tupla.setColumna(seient.getColumna());
				tupla.setFila(seient.getFila());
				oc.add(tupla);
			}
		}

		return oc;
	}
}
