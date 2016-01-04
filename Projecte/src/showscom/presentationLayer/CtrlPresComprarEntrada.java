package showscom.presentationLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.domainLayer.domainControllers.CtrlDomComprarEntrada;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.exceptions.DONoHiHaEspectacles;
import showscom.domainLayer.exceptions.DONoHiHaRepresentacions;
import showscom.domainLayer.exceptions.DOPagamentNoAutoritzat;
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

	public void prContObteOcupacio() {

		int maxFila = 11;
		int maxColumna = 15;

		List<Object> llista2 = Arrays.asList(Arrays.asList(0, 0), Arrays.asList(0, 1), Arrays.asList(0, 2),
				Arrays.asList(0, 3), Arrays.asList(0, 4), Arrays.asList(0, 5), Arrays.asList(0, 6), Arrays.asList(0, 7),
				Arrays.asList(1, 0), Arrays.asList(1, 1), Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
				Arrays.asList(1, 5), Arrays.asList(1, 6), Arrays.asList(1, 7), Arrays.asList(2, 0), Arrays.asList(2, 1),
				Arrays.asList(2, 2), Arrays.asList(2, 3), Arrays.asList(2, 4), Arrays.asList(2, 5), Arrays.asList(2, 6),
				Arrays.asList(2, 7), Arrays.asList(3, 0), Arrays.asList(3, 1), Arrays.asList(3, 2), Arrays.asList(3, 3),
				Arrays.asList(3, 4), Arrays.asList(3, 5), Arrays.asList(3, 6), Arrays.asList(3, 7), Arrays.asList(4, 0),
				Arrays.asList(4, 1), Arrays.asList(4, 2), Arrays.asList(4, 3), Arrays.asList(4, 4), Arrays.asList(4, 5),
				Arrays.asList(4, 6), Arrays.asList(4, 7), Arrays.asList(5, 0), Arrays.asList(5, 1), Arrays.asList(5, 2),
				Arrays.asList(5, 3), Arrays.asList(5, 4), Arrays.asList(5, 5), Arrays.asList(5, 6),
				Arrays.asList(5, 7));

		vistaPres.mostraOcupacio(maxFila, maxColumna, llista2);
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
