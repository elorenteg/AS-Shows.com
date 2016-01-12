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

	public Local() {
	}

	public Local(String nom, String adreca, int maxFila, int maxColumna) {
		super();
		this.nom = nom;
		this.adreca = adreca;

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlLocal ctrlLocal = ctrlDataFact.getCtrlLocal();
		ctrlLocal.insertLocal(this);

		creaSeients(maxFila, maxColumna);
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

	public TuplaSeient getMarges() {
		TuplaSeient tupla = new TuplaSeient();

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
		tupla.setFila(maxFila);
		tupla.setColumna(maxCol);

		return tupla;
	}
}
