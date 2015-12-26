package showscom.PresentationLayer;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

public class VistaComprarEntrada extends JFrame {
	private CtrlPresComprarEntrada ctrlPres;
	private PanellInici panellIni;
	private PanellEspectacle panellEsp;
	private PanellRepresentacio panellRepr;
	private PanellSeients panellSeients;
	private PanellPagament panellPagam;
	private PanellFi panellFi;
	
	public VistaComprarEntrada(final CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		panellIni = new PanellInici(ctrlPres);
		panellEsp = new PanellEspectacle(ctrlPres);
		panellRepr = new PanellRepresentacio(ctrlPres);
		panellSeients = new PanellSeients(ctrlPres);
		panellPagam = new PanellPagament(ctrlPres);
		panellFi = new PanellFi(ctrlPres);

		setMinimumSize(new Dimension(600,600));
		setPreferredSize(new Dimension(600,600));
		getContentPane().setLayout(new CardLayout());
		getContentPane().add(panellIni,  "Inici");
		getContentPane().add(panellEsp,  "Espectacle");
		getContentPane().add(panellRepr,  "Represetacio");
		getContentPane().add(panellSeients,  "Seients");
		getContentPane().add(panellPagam,  "Pagament");
		getContentPane().add(panellFi,  "Confirmacio");
		
		pack();
	}

	public void mostraEspectacles(List<String> espectacles) {
		panellIni.setVisible(false);
		panellEsp.setVisible(true);
		panellRepr.setVisible(false);
		panellSeients.setVisible(false);
		panellPagam.setVisible(false);
		panellFi.setVisible(false);
		
	}
}
