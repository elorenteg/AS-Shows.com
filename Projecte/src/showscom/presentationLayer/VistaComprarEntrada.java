package showscom.presentationLayer;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeient;

public class VistaComprarEntrada extends JFrame {
	private static final long serialVersionUID = 1L;
	
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
		setMinimumSize(new Dimension(900, 650));
		setPreferredSize(new Dimension(900, 650));
		getContentPane().setLayout(new CardLayout());

		panellIni = new PanellInici(ctrlPres, this);
		getContentPane().add(panellIni, "Inici");

		pack();

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				ctrlPres.prCancela();
			}
		});
	}

	public void mostraMissatgeFinalitza(String text) {
		Object[] choices = { "Finalitza" };
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,
				choices, defaultChoice);
		ctrlPres.prFinalitza();
	}

	public void mostraMissatgeEndarrera(String text) {
		Object[] choices = { "Endarrera" };
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,
				choices, defaultChoice);
		ctrlPres.prEndarrera();
	}

	public void mostraEspectacles(List<String> espectacles) {
		panellEsp = new PanellEspectacle(ctrlPres, this, espectacles);
		getContentPane().add(panellEsp, "Espectacle");
		panellIni.setVisible(false);
		panellEsp.setVisible(true);
	}

	public void mostraRepresentacions(List<TuplaRepr> llista) {
		panellRepr = new PanellRepresentacio(ctrlPres, this, llista);
		getContentPane().add(panellRepr, "Representacio");
		panellEsp.setVisible(false);
		panellRepr.setVisible(true);
	}

	public void mostraOcupacio(int maxFila, int maxColumna, List<TuplaSeient> seientsLliures) {
		panellSeients = new PanellSeients(ctrlPres, this, maxFila, maxColumna, seientsLliures);
		getContentPane().add(panellSeients, "Seients");
		panellRepr.setVisible(false);
		panellSeients.setVisible(true);
	}

	public void mostraPagament(float preu, List<String> divises) {
		panellPagam = new PanellPagament(ctrlPres, this, preu, divises);
		getContentPane().add(panellPagam, "Pagament");
		panellSeients.setVisible(false);
		panellPagam.setVisible(true);
	}

	public void mostraFinalitza() {
		panellFi = new PanellFi(ctrlPres, this);
		getContentPane().add(panellFi, "Confirmacio");
		panellPagam.setVisible(false);
		panellFi.setVisible(true);
	}

}
