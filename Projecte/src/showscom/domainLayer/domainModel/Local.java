package showscom.domainLayer.domainModel;

import java.util.ArrayList;
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

import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.dataInterface.ICtrlSeient;
import showscom.domainLayer.factories.CtrlDataFactory;

/**
 * Representaci� d'un Local
 */
@Entity
@Table(name = "Local")
public class Local {
	// Nom del local
	@Id
	@Column(name = "nom")
	private String nom;
	// Adre�a del local
	@Column(name = "adreca")
	private String adreca;
	// Representacions que es realitzen al local
	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	// Seients dels que disposa el local
	private List<Representacio> representacions;
	@OneToMany(targetEntity = Seient.class, mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Seient> seients;

	/**
	 * Constructora per defecte
	 */
	public Local() {
	}

	/**
	 * Constructora amb inicialitzaci� d'atributs
	 * @param nom nom del local
	 * @param adreca adre�a del local
	 * @param maxFila n�m. m�xim de files del local
	 * @param maxColumna n�m. m�xim de columnes del local
	 */
	public Local(String nom, String adreca, int maxFila, int maxColumna) {
		super();
		this.nom = nom;
		this.adreca = adreca;

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlLocal ctrlLocal = ctrlDataFact.getCtrlLocal();
		ctrlLocal.insertLocal(this);

		creaSeients(maxFila, maxColumna);
	}

	/**
	 * Consultora del nom del local
	 * @return nom del local
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Obt� el n�m. m�xim de fila i columna del local
	 * @return Tupla amb la fila i columna m�xima
	 */
	public TuplaSeient getMarges() {
		int maxCol = 0;
		int maxFila = 0;
		for (Seient s : seients) {
			int col = s.getColumna();
			int fila = s.getFila();
			if (col > maxCol)
				maxCol = col;
			if (fila > maxFila)
				maxFila = fila;
		}

		TuplaSeient tupla = new TuplaSeient(maxFila, maxCol);

		return tupla;
	}

	/**
	 * Creadora de seients del local
	 * @param maxFila n�m. m�xim de files de seients a crear
	 * @param maxColumna n�m. m�xim de columnes de seients a crear
	 */
	private void creaSeients(int maxFila, int maxColumna) {
		seients = new ArrayList<Seient>();

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlSeient ctrlSeient = ctrlDataFact.getCtrlSeient();

		for (int i = 1; i <= maxFila; ++i) {
			for (int j = 1; j <= maxColumna; ++j) {
				Seient seient = new Seient(i, j, this);
				seients.add(seient);
				ctrlSeient.insertSeient(seient);
			}
		}
	}
}
