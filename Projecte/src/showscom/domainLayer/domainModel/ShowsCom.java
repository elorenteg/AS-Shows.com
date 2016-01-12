package showscom.domainLayer.domainModel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.CollectionOfElements;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlShowsCom;
import showscom.domainLayer.factories.CtrlDataFactory;

@Entity
@Table(name = "ShowsCom")
@Check(constraints = "codiBanc > 0 AND comissio > 0")
public class ShowsCom {
	private static ShowsCom instance;

	static {
		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlShowsCom ctrlShows = ctrlDataFact.getCtrlShows();
		try {
			instance = ctrlShows.getShowsCom();
		} catch (CDShowsComNoExisteix e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "codiBanc")
	private int codiBanc;
	@Column(name = "nCompte")
	private String numeroCompte;
	@Column(name = "comissio")
	private float comissio;
	@Column(name = "divisa")
	@Enumerated(EnumType.STRING)
	private Moneda divisa;

	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name = "Canvis")
	@Column(name = "canvi", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Moneda> canvis;

	@Column(name = "idVenudes")
	private int venudes;

	/*
	 * Un Constructor privat preve que una altra classe instancii la classe
	 */
	private ShowsCom() {
	}

	/* Metode estatic 'instance' */
	public static ShowsCom getInstance() {
		return instance;
	}

	public int getCodiBanc() {
		return codiBanc;
	}

	public void setCodiBanc(int codiBanc) {
		this.codiBanc = codiBanc;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public float getComissio() {
		return comissio;
	}

	public void setComissio(float comissio) {
		this.comissio = comissio;
	}

	public Moneda getDivisa() {
		return divisa;
	}

	public void setDivisa(Moneda divisa) {
		this.divisa = divisa;
	}

	public List<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(List<Moneda> canvis) {
		this.canvis = canvis;
	}

	public int incrementaVenudes() {
		int aux = venudes;
		++venudes;

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlShowsCom ctrlShows = ctrlDataFact.getCtrlShows();
		ctrlShows.actualitzaShowsCom(instance);

		return aux;
	}

	public static void setInstance(ShowsCom instance) {
		ShowsCom.instance = instance;
	}
}
