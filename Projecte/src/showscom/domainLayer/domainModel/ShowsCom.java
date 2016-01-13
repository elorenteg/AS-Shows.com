package showscom.domainLayer.domainModel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.CollectionOfElements;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.domainLayer.dataInterface.ICtrlShowsCom;
import showscom.domainLayer.factories.CtrlDataFactory;

/*
 * Representaci� del sistema de Shows.com amb la seva informaci�
 */
@Entity
@Table(name = "ShowsCom")
@Check(constraints = "codiBanc > 0 AND comissio > 0 AND divisa = 'EUR'")
public class ShowsCom {
	// Inst�ncia de Shows.com
	private static ShowsCom instance = null;

	// Identificador de la inst�ncia
	@Id
	private int id = 1;

	// Codi del banc del sistema de Shows.com
	@Column(name = "codiBanc")
	private int codiBanc;
	// N�mero del compte del sistema de Shows.com
	@Column(name = "nCompte")
	private String numeroCompte;
	// Comissi� de pagament
	@Column(name = "comissio")
	private float comissio;
	// Divisa dels preus del sistema de Shows.com
	@Column(name = "divisa")
	@Enumerated(EnumType.STRING)
	private Moneda divisa;

	// Canvis de divisa disponibles de pagament
	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name = "Canvis", joinColumns = { @JoinColumn(name = "id") })
	@Column(name = "canvi", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private List<Moneda> canvis;

	// Identificador de la seg�ent entrada a vendre
	@Column(name = "idVenudes")
	private int venudes;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin instancia
	 * la classe
	 */
	private ShowsCom() {
	}

	/**
	 * Consultor de la inst�ncia de Shows.com. Si no s'havia instancia, es
	 * s'inicialitza la inst�ncia. Evita que hi hagi m�s d'1 inst�ncia de
	 * Shows.com
	 * @return inst�ncia del sistema de Shows.com
	 */
	public static ShowsCom getInstance() {
		if (instance == null) {
			CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
			ICtrlShowsCom ctrlShows = ctrlDataFact.getCtrlShows();
			try {
				instance = ctrlShows.getShowsCom();
			} catch (CDShowsComNoExisteix e) {
				// Do nothing. Mai s'executa
			}
		}

		return instance;
	}

	/**
	 * Consultora del codi del banc del sistema de Shows.com
	 * @return codi del banc
	 */
	public int getCodiBanc() {
		return codiBanc;
	}

	/**
	 * Consultora del n�m. de compte del sistema de Shows.com
	 * @return n�m. de compte del banc
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Consultora de la comissi� del sistema de Shows.com
	 * @return comissi�
	 */
	public float getComissio() {
		return comissio;
	}

	/**
	 * Divisa de pagament principal del sistema de Shows.com
	 * @return divisa principal
	 */
	public Moneda getDivisa() {
		return divisa;
	}

	/**
	 * Divises alternatives del sistema de Shows.com
	 * @return
	 */
	public List<Moneda> getCanvis() {
		return canvis;
	}

	/**
	 * Obt� l'identificador de l'entrada que es vol comprar i incrementa
	 * l'identificador de la seg�ent entrada
	 * @return l'identificador de l'entrada comprada
	 */
	public int incrementaVenudes() {
		int aux = venudes;
		++venudes;

		CtrlDataFactory ctrlDataFact = CtrlDataFactory.getInstance();
		ICtrlShowsCom ctrlShows = ctrlDataFact.getCtrlShows();
		ctrlShows.updateShowsCom(instance);

		return aux;
	}
}