package showscom.PresentationLayer;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents() {
		panellIni = new PanellInici(ctrlPres, this);
		panellEsp = new PanellEspectacle(ctrlPres, this);
		panellRepr = new PanellRepresentacio(ctrlPres, this);
		panellSeients = new PanellSeients(ctrlPres, this);
		panellPagam = new PanellPagament(ctrlPres, this);
		panellFi = new PanellFi(ctrlPres, this);

		setMinimumSize(new Dimension(900,650));
		setPreferredSize(new Dimension(900,650));
		getContentPane().setLayout(new CardLayout());
		getContentPane().add(panellIni,  "Inici");
		getContentPane().add(panellEsp,  "Espectacle");
		getContentPane().add(panellRepr,  "Represetacio");
		getContentPane().add(panellSeients,  "Seients");
		getContentPane().add(panellPagam,  "Pagament");
		getContentPane().add(panellFi,  "Confirmacio");
		
		pack();
	}

	public void mostraMissatgeFinalitza(String text) {
		Object[] choices = {"Finalitza"};
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,choices, defaultChoice);
		ctrlPres.prFinalitza();
	}

	public void mostraMissatgeEndarrera(String text) {
		Object[] choices = {"Endarrera"};
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,choices, defaultChoice);
		ctrlPres.prEndarrera();
	}
	
	public void mostraEspectacles(List<String> espectacles) {
		panellIni.setVisible(false);
		panellEsp.setVisible(true);
		panellRepr.setVisible(false);
		panellSeients.setVisible(false);
		panellPagam.setVisible(false);
		panellFi.setVisible(false);
		
		panellEsp.mostraEspectacles(espectacles);
	}
	
	public void mostraRepresentacions(List<Object> llista) {
		panellIni.setVisible(false);
		panellEsp.setVisible(false);
		panellRepr.setVisible(true);
		panellSeients.setVisible(false);
		panellPagam.setVisible(false);
		panellFi.setVisible(false);

		panellRepr.mostraRepresentacions(llista);
	}
	
	public void mostraPagament(float preu, List<String> divises) {
		panellIni.setVisible(false);
		panellEsp.setVisible(false);
		panellRepr.setVisible(false);
		panellSeients.setVisible(false);
		panellPagam.setVisible(true);
		panellFi.setVisible(false);

		panellPagam.mostraPagament(preu, divises);
	}
	
	public void mostraFinalitza() {
		panellIni.setVisible(false);
		panellEsp.setVisible(false);
		panellRepr.setVisible(false);
		panellSeients.setVisible(false);
		panellPagam.setVisible(false);
		panellFi.setVisible(true);
	}
	
}
