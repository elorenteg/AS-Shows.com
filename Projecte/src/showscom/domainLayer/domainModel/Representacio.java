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

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.dataLayer.exceptions.CDSeientNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.dataInterface.ICtrlSeient;
import showscom.domainLayer.dataInterface.ICtrlSeientEnRepresentacio;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.factories.CtrlDataFactory;

@Entity
@Table(name = "Representacio")
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

	private void creaSeientsEnRepresentacio(int maxFila, int maxColumna) {
		seientsEnRepresentacio = new ArrayList<SeientEnRepresentacio>();

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlSeient ctrlSeient = ctrlDataFact.getCtrlSeient();
		ICtrlSeientEnRepresentacio ctrlSeientEnRepr = ctrlDataFact.getCtrlSeientEnRepresentacio();

		Seient seient = null;

		for (int i = 1; i <= maxFila; ++i) {
			for (int j = 1; j <= maxColumna; ++j) {
				try {
					seient = ctrlSeient.getSeient(local.getNom(), i, j);
				} catch (CDSeientNoExisteix e) {
					// Do nothing. Mai s'executa
				}

				SeientEnRepresentacio aux = new SeientEnRepresentacio(seient, this);
				seientsEnRepresentacio.add(aux);
				ctrlSeientEnRepr.guardaSeientEnRepresentacio(aux);
			}
		}
	}

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

		TuplaSeient max = local.getMarges();
		creaSeientsEnRepresentacio(max.getFila(), max.getColumna());
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

	public TuplaRepr obteInformacio() {
		TuplaRepr tupla = new TuplaRepr();

		tupla.setSessio(sessio.getSessio().name());
		tupla.setLocal(local.getNom());
		tupla.setNombreSeientsLliures(nombreSeientsLliures);
		tupla.setEsEstrena(esEstrena());
		tupla.setPreu(preu);
		tupla.setRecarrec(getRecarrec());

		return tupla;
	}

	public boolean esEstrena() {
		return false;
	}

	public int getRecarrec() {
		return 0;
	}

	public void reservarSeients(List<TuplaSeient> seients, Entrada entrada) {
		String nom = this.local.getNom();
		String sessio = this.sessio.getSessio().name();
		this.nombreSeientsLliures -= seients.size();

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlSeientEnRepresentacio ctrlSeient = ctrlDataFact.getCtrlSeientEnRepresentacio();
		ICtrlRepresentacio ctrlRepresentacio = ctrlDataFact.getCtrlRepresentacio();

		ctrlRepresentacio.actualitzaRepresentacio(this);

		for (TuplaSeient tupla : seients) {
			SeientEnRepresentacio seient = null;
			try {
				seient = ctrlSeient.getSeientEnRepresentacio(tupla.getFila(), tupla.getColumna(), nom, sessio);
			} catch (CDSeientEnRepresentacioNoExisteix e) {
				// Do nothing. Mai s'executa
			}
			seient.ocupat(entrada);
			ctrlSeient.actualitzaSeientEnRepresentacio(seient);
		}
	}

	public List<TuplaSeient> obteSeientsLliures(int nombreEspectadors) throws DOSeientsNoDisp {
		if (this.nombreSeientsLliures < nombreEspectadors)
			throw new DOSeientsNoDisp();

		List<TuplaSeient> oc = new ArrayList<>();

		for (SeientEnRepresentacio seient : seientsEnRepresentacio) {
			if (seient.esSeientLliure())
				oc.add(seient.getPosicioSeient());
		}

		return oc;
	}
}
