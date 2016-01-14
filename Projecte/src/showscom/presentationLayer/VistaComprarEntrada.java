package showscom.presentationLayer;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import showscom.domainLayer.domainModel.Moneda;
import showscom.domainLayer.domainModel.TuplaRepr;
import showscom.domainLayer.domainModel.TuplaSeient;

/**
 * Controlador de la Vista de la Capa de Presentacio
 */
public class VistaComprarEntrada extends JFrame {
	private static final long serialVersionUID = 1L;

	// Instancia de la Capa de Presentacio
	private CtrlPresComprarEntrada ctrlPres;

	// Instancia del Panell d'Inici
	private PanellInici panellIni;
	// Instancia del Panell d'Espectacles
	private PanellEspectacle panellEsp;
	// Instancia del Panell de Representacions
	private PanellRepresentacio panellRepr;
	// Instancia del Panell de Seients
	private PanellSeients panellSeients;
	// Instancia del Panell de Pagament
	private PanellPagament panellPagam;
	// Instancia del Panell de Finalizacio
	private PanellFi panellFi;

	/**
	 * Constructora de la Vista de la Capa de Presentacio
	 * @param ctrlPres intancia del Controlador de la Capa de Presentacio
	 */
	public VistaComprarEntrada(final CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Inicialitza els components visuals generals per a tots els panells i
	 * inicia el Panell d'Inici
	 */
	private void initComponents() {
		setMinimumSize(new Dimension(900, 650));
		setPreferredSize(new Dimension(900, 650));
		setResizable(false);
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

	/**
	 * Mostra el missatge extern de finalitzacio de l'aplicacio
	 * @param text missatge a mostrar
	 */
	public void mostraMissatgeFinalitza(String text) {
		Object[] choices = { "Finalitza" };
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,
				choices, defaultChoice);
		ctrlPres.prFinalitza();
	}

	/**
	 * Mostra el missatge extern amb possibilitat d'anar endarrera
	 * @param text missatge a mostrar
	 */
	public void mostraMissatgeEndarrera(String text) {
		Object[] choices = { "Endarrera" };
		Object defaultChoice = choices[0];
		JOptionPane.showOptionDialog(this, text, "Atenció", JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null,
				choices, defaultChoice);
		ctrlPres.prEndarrera();
	}

	/**
	 * Inicialitza el Panell d'Espectacles i mostra els espectacles disponibles
	 * al sistema
	 * @param espectacles llista d'espectacles disponibles
	 */
	public void mostraEspectacles(List<String> espectacles) {
		panellEsp = new PanellEspectacle(ctrlPres, this, espectacles);
		getContentPane().add(panellEsp, "Espectacle");
		panellIni.setVisible(false);
		panellEsp.setVisible(true);
	}

	/**
	 * Inicialitza el Panell de Representacio i mostra les representacions d'un
	 * espectacle i una data selecciona anteriorment
	 * @param llista llista amb la informacio de les representacions
	 * @param divisa moneda en la que es mostren els preus de les
	 *        representacions
	 */
	public void mostraRepresentacions(List<TuplaRepr> llista, Moneda divisa) {
		panellRepr = new PanellRepresentacio(ctrlPres, this, llista, divisa);
		getContentPane().add(panellRepr, "Representacio");
		panellEsp.setVisible(false);
		panellRepr.setVisible(true);
	}

	/**
	 * Inicialitza el Panell de Seients i mostra els seients del local de la
	 * representacio selecciona
	 * @param maxFila maxim numero de files del local
	 * @param maxColumna maxim numero de columnes del local
	 * @param seientsLliures llista amb els seients disponibles al local
	 */
	public void mostraOcupacio(int maxFila, int maxColumna, List<TuplaSeient> seientsLliures) {
		panellSeients = new PanellSeients(ctrlPres, this, maxFila, maxColumna, seientsLliures, panellRepr.getNumEsp());
		getContentPane().add(panellSeients, "Seients");
		panellRepr.setVisible(false);
		panellSeients.setVisible(true);
	}

	/**
	 * Inicialitza el Panell de Pagament i mostra el preu total de les entrades
	 * i la forma de pagament
	 * @param preu preu total de les entrades
	 * @param canvis divises en les que podem realitzar el pagament
	 */
	public void mostraPagament(float preu, List<String> canvis) {
		panellPagam = new PanellPagament(ctrlPres, this, preu, canvis, panellRepr.getDivisa());
		getContentPane().add(panellPagam, "Pagament");
		panellSeients.setVisible(false);
		panellPagam.setVisible(true);
	}

	/**
	 * Actualitza el preu en una altra moneda
	 * @param preu preu total de les entrades en la nova moneda
	 */
	public void mostraConversio(float preu) {
		panellPagam.actualitzaPreu(preu);
	}

	/**
	 * Inicialitza el Panell de Finalitzacio i mostra un avis confirmant que
	 * s'ha realitzat correctament el pagament
	 */
	public void mostraFinalitza() {
		panellFi = new PanellFi(ctrlPres, this);
		getContentPane().add(panellFi, "Confirmacio");
		panellPagam.setVisible(false);
		panellFi.setVisible(true);
	}

}
