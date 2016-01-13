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

/**
 * Representació d'una Representació d'espectacle
 */
@Entity
@Table(name = "Representacio")
@Inheritance(strategy = InheritanceType.JOINED)
@Check(constraints = "preu > 0 AND nSeientsLliures >= 0")
public class Representacio implements Serializable {
	// Identificador de la Representació
	@Id
	@Embedded
	private RepresentacioPK representacioPK;
	// Títol de l'espectacle de la representació
	@Column(name = "titolE", nullable = false)
	private String titolE;
	// Preu de la representació
	@Column(name = "preu")
	private float preu;
	// Data de la representació
	@Column(name = "data")
	private Date data;
	// Núm. de seients lliures de la representació
	@Column(name = "nSeientsLliures")
	private int nombreSeientsLliures;
	// Sessió de la representació
	@ManyToOne
	@JoinColumn(name = "sessio", referencedColumnName = "sessio", insertable = false, updatable = false)
	private Sessio sessio;
	// Local de la representació
	@ManyToOne
	@JoinColumn(name = "nomL", referencedColumnName = "nom", insertable = false, updatable = false)
	private Local local;
	// Seients de la representació
	@OneToMany(targetEntity = SeientEnRepresentacio.class, mappedBy = "representacio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SeientEnRepresentacio> seientsEnRepresentacio;

	/**
	 * Creadora per defecte
	 */
	public Representacio() {
	}

	/**
	 * Creadora amb inicialització d'atributs
	 * @param sessio sessió de la representació
	 * @param local local de la representació
	 * @param titolEsp títol de l'espectacle de la representació
	 * @param preu preu base de la representació
	 * @param data data de la represntació
	 * @param nombreSeientsLliures núm. de seients lliures de la representació
	 */
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

	/**
	 * Consultora del preu de la representació
	 * @return preu de la representació
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Consultora de la data de la representació
	 * @return data de la representació
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Consultora de la sessió de la representació
	 * @return sessió de la representació
	 */
	public Sessio getSessio() {
		return sessio;
	}

	/**
	 * Consultora del local de la representació
	 * @return local de la representació
	 */
	public Local getLocal() {
		return local;
	}

	/**
	 * Comprova si la representació és una estrena
	 * @return retorna que no és una estrena
	 */
	public boolean esEstrena() {
		return false;
	}

	/**
	 * Consultora del recàrrec de la representació
	 * @return si no és una estrena, el recàrrec és de 0
	 */
	public int getRecarrec() {
		return 0;
	}

	/**
	 * Obté la informació de la representació
	 * @return Tupla amb la sessió, local, núm. de seients lliures, si és
	 *         estrena, preu i recàrrec
	 */
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

	/**
	 * Reserva els seients de la compra d'una entrada i els posa com a ocupats
	 * @param seients seients que s'han comprat
	 * @param entrada entrada assignada als seients
	 */
	public void reservarSeients(List<TuplaSeient> seients, Entrada entrada) {
		String nom = this.local.getNom();
		String sessio = this.sessio.getSessio().name();
		this.nombreSeientsLliures -= seients.size();

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlSeientEnRepresentacio ctrlSeient = ctrlDataFact.getCtrlSeientEnRepresentacio();
		ICtrlRepresentacio ctrlRepresentacio = ctrlDataFact.getCtrlRepresentacio();

		ctrlRepresentacio.updateRepresentacio(this);

		for (TuplaSeient tupla : seients) {
			SeientEnRepresentacio seient = null;
			try {
				seient = ctrlSeient.getSeientEnRepresentacio(tupla.getFila(), tupla.getColumna(), nom, sessio);
			} catch (CDSeientEnRepresentacioNoExisteix e) {
				// Do nothing. Mai s'executa
			}
			seient.ocupat(entrada);
			ctrlSeient.updateSeientEnRepresentacio(seient);
		}
	}

	/**
	 * Obté els seients disponibles per la representació
	 * @param nombreEspectadors núm. d'espectadors que es volen seure
	 * @return llista amb els seients disponibles al local de la representació
	 * @throws DOSeientsNoDisp si no hi ha suficients seients pels espectadors
	 */
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

	/**
	 * Creadora de seients de la representació
	 * @param maxFila núm màxim de files del local de la representació
	 * @param maxColumna núm màxim de columnes del local de la representació
	 */
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
				ctrlSeientEnRepr.insertSeientEnRepresentacio(aux);
			}
		}
	}
}
