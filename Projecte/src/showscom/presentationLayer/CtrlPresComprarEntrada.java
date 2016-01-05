package showscom.presentationLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;
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

			// Solo para probar que obtiene la informacion
			for (TuplaRepr tr : llista) {
				System.out.println(tr.getSessio() + " - " + tr.getLocal() + " - " + tr.getNombreSeientsLliures() + " - "
						+ tr.getEsEstrena() + " - " + tr.getPreu());
			}
			vistaPres.mostraRepresentacions(llista);
		} catch (DONoHiHaRepresentacions e) {
			vistaPres.mostraMissatgeEndarrera("No hi ha cap representació disponible");
		}
	}

	public void prContObteOcupacio(String nomL, String sessio, int nombreEspectadors) {
		/*int maxFila = 11;
		int maxColumna = 15;

		List<TuplaSeient> seientsLliures = Arrays.asList(new TuplaSeient(0, 0), new TuplaSeient(0, 1),
				new TuplaSeient(0, 2), new TuplaSeient(0, 3), new TuplaSeient(0, 4), new TuplaSeient(0, 5),
				new TuplaSeient(0, 6), new TuplaSeient(0, 7), new TuplaSeient(1, 0), new TuplaSeient(1, 1),
				new TuplaSeient(1, 2), new TuplaSeient(1, 3), new TuplaSeient(1, 4), new TuplaSeient(1, 5),
				new TuplaSeient(1, 6), new TuplaSeient(1, 7), new TuplaSeient(2, 0), new TuplaSeient(2, 1),
				new TuplaSeient(2, 2), new TuplaSeient(2, 3), new TuplaSeient(2, 4), new TuplaSeient(2, 5),
				new TuplaSeient(2, 6), new TuplaSeient(2, 7), new TuplaSeient(3, 0), new TuplaSeient(3, 1),
				new TuplaSeient(3, 2), new TuplaSeient(3, 3), new TuplaSeient(3, 4), new TuplaSeient(3, 5),
				new TuplaSeient(3, 6), new TuplaSeient(3, 7), new TuplaSeient(4, 0), new TuplaSeient(4, 1),
				new TuplaSeient(4, 2), new TuplaSeient(4, 3), new TuplaSeient(4, 4), new TuplaSeient(4, 5),
				new TuplaSeient(4, 6), new TuplaSeient(4, 7), new TuplaSeient(5, 0), new TuplaSeient(5, 1),
				new TuplaSeient(5, 2), new TuplaSeient(5, 3), new TuplaSeient(5, 4), new TuplaSeient(5, 5),
				new TuplaSeient(5, 6), new TuplaSeient(5, 7));

		vistaPres.mostraOcupacio(maxFila, maxColumna, seientsLliures);
		*/
		try {
			TuplaSeient marge = ctrlDom.obteMarges(nomL);
			int maxFila = marge.getFila();
			int maxColumna = marge.getColumna();
			List<TuplaSeient> seientsLliures = ctrlDom.obteOcupacio(nomL, sessio, nombreEspectadors);
			vistaPres.mostraOcupacio(maxFila, maxColumna, seientsLliures);
		} catch (DOSeientsNoDisp e){
			vistaPres.mostraMissatgeEndarrera("El nombre d'espectadors es més gran que els seients disponibles");
		} catch (CDLocalNoExisteix e){
			//no s'executa
		}
	}

	public void prContSeleccionarSeients() {
		// vistaPres.mostraRepresentacions(llista);
		List<String> divises = new ArrayList<>();
		divises.add("GBP");
		divises.add("USD");
		vistaPres.mostraPagament(10, divises);
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
