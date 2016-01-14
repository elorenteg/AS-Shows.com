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
 * Representacio del sistema de Shows.com amb la seva informacio
 */
@Entity
@Table(name = "ShowsCom")
@Check(constraints = "codiBanc > 0 AND comissio > 0 AND divisa = 'EUR'")
public class ShowsCom {
	// Instancia de Shows.com
	private static ShowsCom instance = null;

	// Identificador de la instancia
	@Id
	private int id = 1;

	// Codi del banc del sistema de Shows.com
	@Column(name = "codiBanc")
	private int codiBanc;
	// Numero del compte del sistema de Shows.com
	@Column(name = "nCompte")
	private String numeroCompte;
	// Comissio de pagament
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

	// Identificador de la seguent entrada a vendre
	@Column(name = "idVenudes")
	private int venudes;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin
	 * instanciar la classe
	 */
	private ShowsCom() {
	}

	/**
	 * Consultor de la instancia de Shows.com. Si no s'havia instancia, es
	 * s'inicialitza la instancia. Evita que hi hagi mes d'1 instancia de
	 * Shows.com
	 * @return instancia del sistema de Shows.com
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
	 * Consultora del num. de compte del sistema de Shows.com
	 * @return num. de compte del banc
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Consultora de la comissio del sistema de Shows.com
	 * @return comissio
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
	 * @return divises alternatives
	 */
	public List<Moneda> getCanvis() {
		return canvis;
	}

	/**
	 * Obte l'identificador de l'entrada que es vol comprar i incrementa
	 * l'identificador de la seguent entrada
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