package showscom.PresentationLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.DomainLayer.domain_controllers.CtrlDomComprarEntrada;
import showscom.DomainLayer.exceptions.DONoHiHaEspectacles;
import showscom.DomainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.DomainLayer.exceptions.DOPagamentNoAutoritzat;
import showscom.DomainLayer.exceptions.DOServeiNoDisponible;

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
		// TODO:
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
			List<Object> llista = ctrlDom.obteRepresentacions(titol, data);
			// vistaPres.mostraRepresentacions(llista);
			List<String> divises = new ArrayList<>();
			divises.add("GBP");
			divises.add("USD");
			vistaPres.mostraPagament(10, divises);
		} catch (DONoHiHaRepresentacions e) {
			vistaPres.mostraMissatgeEndarrera("No hi ha cap representació disponible");
		}
	}

	public void prContObteOcupacio() {
	}

	public void prContSeleccionarSeients() {
	}

	public void prComboObtePreuMoneda() {
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
