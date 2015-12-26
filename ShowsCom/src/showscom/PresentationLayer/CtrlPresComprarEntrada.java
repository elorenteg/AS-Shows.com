package showscom.PresentationLayer;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import showscom.DomainLayer.domain_controllers.CtrlDomComprarEntrada;

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
		int confirm = JOptionPane.showConfirmDialog(null, "Segur que vols sortir?", "Atencio", JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			prFinalitza();
		}
	}
	
	public void prContObteEspectacles() {
		List<String> espectacles = ctrlDom.obteEspectacles();
		vistaPres.mostraEspectacles(espectacles);
	}
	
	public void prContObteRepresentacions() {}
	
	public void prContObteOcupacio() {}
	
	public void prContSeleccionarSeients() {}
	
	public void prComboObtePreuMoneda() {}
	
	public void prContPagament(String dni, int codiB, String numCompte) {}
	
}
