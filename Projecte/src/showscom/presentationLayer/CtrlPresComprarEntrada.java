package showscom.presentationLayer;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;
import showscom.domainLayer.domainModel.Moneda;
import showscom.domainLayer.domainModel.TuplaPreu;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeient;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.exceptions.DOPagamentNoAutoritzat;
import showscom.domainLayer.exceptions.DOSeientsNoDisp;
import showscom.domainLayer.exceptions.DOServeiNoDisponible;

/**
 * Controlador de la Capa de Presentació
 */
public class CtrlPresComprarEntrada {
	// Instància del Controlador de la Capa de Domini
	CtrlDomComprarEntrada ctrlDom;
	// Instància de la Vista de la Capa de Presentació
	VistaComprarEntrada vistaPres;

	/**
	 * Constructora del Contorlador de la Capa de Presentació. Inicialitza el
	 * Controlador de la Capa de Domini i la Vista de la Capa de Presentació
	 */
	public CtrlPresComprarEntrada() {
		vistaPres = new VistaComprarEntrada(this);
		ctrlDom = new CtrlDomComprarEntrada();
	}

	/**
	 * S'acciona quan es prem el botó Finalitza. La seva acció és la de tancar
	 * l'aplicació.
	 */
	public void prFinalitza() {
		System.exit(0);
	}

	/**
	 * S'acciona quan es prem el botó Endarrera. No fa res.
	 */
	public void prEndarrera() {
		// Do nothing
	}

	/**
	 * S'acciona quan es prem el botó Cancel·la. La seva acció és la de mostrar
	 * un avís preguntant si es vol tancar l'aplicació.
	 */
	public void prCancela() {
		String ObjButtons[] = { "Si", "No" };
		int confirm = JOptionPane.showOptionDialog(null, "Segur que vols sortir?", "Atencio",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
		if (confirm == JOptionPane.YES_OPTION) {
			prFinalitza();
		}
	}

	/**
	 * S'acciona quan es prem el botó Continua al Panell Inicial. Obté els
	 * espectacles del sistema i els mostra a la Vista de la Capa de Presentació
	 */
	public void prContObteEspectacles() {
		try {
			List<String> espectacles = ctrlDom.obteEspectacles();
			vistaPres.mostraEspectacles(espectacles);
		} catch (DONoHiHaEspectacles e) {
			vistaPres.mostraMissatgeFinalitza("No hi ha cap espectacle disponible");
		}
	}

	/**
	 * S'acciona quan es prem el botó Continua al Panell d'Espectacles. Obté les
	 * representacions del sistema i les mostra a la Vista de la Capa de
	 * Presentació
	 * @param titol titol de l'Espectacle
	 * @param data data de l'Espectacle
	 */
	public void prContObteRepresentacions(String titol, Date data) {
		try {
			List<TuplaRepr> llista = ctrlDom.obteRepresentacions(titol, data);
			Moneda divisa = ctrlDom.obteDivisa();
			vistaPres.mostraRepresentacions(llista, divisa);
		} catch (DONoHiHaRepresentacions e) {
			vistaPres.mostraMissatgeEndarrera("No hi ha cap representació disponible");
		}
	}

	/**
	 * S'acciona quan es prem el botó Continua al Panell de Representacions.
	 * Obté els seients disponibles de la representacio seleccionada del sistema
	 * i els mostra a la Vista de la Capa de Presentació
	 * @param nomL nom del Local de la Representació
	 * @param sessio sessió de la Representació
	 * @param nombreEspectadors núm. d'entrades que es volen comprar
	 */
	public void prContObteOcupacio(String nomL, String sessio, int nombreEspectadors) {
		try {
			TuplaSeient marge = ctrlDom.obteMarges(nomL);
			int maxFila = marge.getFila();
			int maxColumna = marge.getColumna();
			List<TuplaSeient> seientsLliures = ctrlDom.obteOcupacio(nomL, sessio, nombreEspectadors);
			vistaPres.mostraOcupacio(maxFila, maxColumna, seientsLliures);
		} catch (DOSeientsNoDisp e) {
			vistaPres.mostraMissatgeEndarrera("El nombre d'espectadors es més gran que els seients disponibles");
		}
	}

	/**
	 * S'acciona quan es prem el botó Continua al Panell de Seients. Obté el
	 * preu total de les entrades de la representació i el mostra a la Vista de
	 * la Capa de Presentació
	 * @param seients seients seleccionats per l'usuari a comprar
	 */
	public void prContSeleccionarSeients(List<TuplaSeient> seients) {
		TuplaPreu tupla = ctrlDom.seleccionarSeients(seients);
		vistaPres.mostraPagament(tupla.getPreu(), tupla.getCanvis());
	}

	/**
	 * S'acciona quan es canvia la moneda per pagar al Panell de Pagament. Obté
	 * el preu total de les entrades aplicant-li una conversió per canvi de
	 * moneda i el mostra a la Vista de la Capa de Presentació
	 * @param moneda moneda en la que es vol obtenir el preu
	 */
	public void prComboObtePreuMoneda(String moneda) {
		try {
			float preu = ctrlDom.obtePreuMoneda(moneda);
			vistaPres.mostraConversio(preu);
		} catch (DOServeiNoDisponible e) {
			vistaPres.mostraMissatgeEndarrera("El servei no està disponible o no autoritza el pagament");
		}
	}

	/**
	 * S'acciona quan es prem el botó Continua al Panell de Pagament. Realitza
	 * el pagament de les entrades i mostra un avís de finalització de la compra
	 * a la Vista de la Capa de Presentació
	 */
	public void prContPagament(String dni, int codiB, String numCompte) {
		try {
			ctrlDom.pagament(dni, codiB, numCompte);
			vistaPres.mostraFinalitza();
		} catch (DOServeiNoDisponible e) {
			vistaPres.mostraMissatgeEndarrera("El servei no està disponible o no autoritza el pagament");
		} catch (DOPagamentNoAutoritzat e) {
			vistaPres.mostraMissatgeEndarrera("El pagament no s'autoritza");
		}
	}

}
