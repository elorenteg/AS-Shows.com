package showscom.presentationLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
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

public class CtrlPresComprarEntrada {
	CtrlDomComprarEntrada ctrlDom;
	VistaComprarEntrada vistaPres;

	public CtrlPresComprarEntrada() {
		vistaPres = new VistaComprarEntrada(this);
		ctrlDom = new CtrlDomComprarEntrada();
	}

	public void prFinalitza() {
		System.exit(0);
	}

	public void prEndarrera() {
		// no fa res
	}

	public void prCancela() {
		String ObjButtons[] = { "Si", "No" };
		int confirm = JOptionPane.showOptionDialog(null, "Segur que vols sortir?", "Atencio",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
		if (confirm == JOptionPane.YES_OPTION) {
			prFinalitza();
		}
	}

	public void prContObteEspectacles() {
		try {
			List<String> espectacles = ctrlDom.obteEspectacles();
			vistaPres.mostraEspectacles(espectacles);
		} catch (DONoHiHaEspectacles e) {
			vistaPres.mostraMissatgeFinalitza("No hi ha cap espectacle disponible");
		}
	}

	public void prContObteRepresentacions(String titol, Date data) {
		try {
			List<TuplaRepr> llista = ctrlDom.obteRepresentacions(titol, data);
			vistaPres.mostraRepresentacions(llista);
		} catch (DONoHiHaRepresentacions e) {
			vistaPres.mostraMissatgeEndarrera("No hi ha cap representació disponible");
		}
	}

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

	public void prContSeleccionarSeients(List<TuplaSeient> seients) {
		TuplaPreu tupla = ctrlDom.seleccionarSeients(seients);
		vistaPres.mostraPagament(tupla.getPreu(), tupla.getCanvis());
	}

	public void prComboObtePreuMoneda(Moneda moneda) {
		try {
			float preu = ctrlDom.obtePreuMoneda(moneda);
			vistaPres.mostraConversio(preu);
		} catch (DOServeiNoDisponible e) {
			vistaPres.mostraMissatgeEndarrera("El servei no està disponible o no autoritza el pagament");
		}
	}

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
