package showscom.presentationLayer;

import java.util.ArrayList;
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
		
		int maxFila = 15;
		int maxColumna = 10;

		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);
		List<Integer> l3 = new ArrayList<>();
		l3.add(2);
		l3.add(1);
		List<Integer> l4 = new ArrayList<>();
		l4.add(2);
		l4.add(2);
		List<Object> llista2 = new ArrayList<>();
		llista2.add(l1);
		llista2.add(l2);
		llista2.add(l3);
		llista2.add(l4);

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
