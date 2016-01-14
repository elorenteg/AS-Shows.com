package showscom.presentationLayer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import showscom.domainLayer.domainModel.TuplaSeient;

/**
 * Controla la visualitzacio grafica del Panell de Seients
 */
public class PanellSeients extends JPanel {
	private static final long serialVersionUID = 1L;

	// Instancia del Controlador de la Capa de Domini
	CtrlPresComprarEntrada ctrlPres;
	// Instancia de la Vista de la Capa de Presentacio
	VistaComprarEntrada vistaPres;

	// Instancia del boto Continua al panell
	private JButton btnContinua;
	// Instancia del boto Cancel·la al panell
	private JButton btnCancela;

	// Canvas per visualitzar els seients del local
	private MyCanvas canvas;
	// Numero d'entrades que es volen comprar
	private int numEsp;

	/**
	 * Constructora del Panell de Seients. Inicialitza la visualizacio grafica
	 * del panell i els seus atributs i comportaments
	 * @param ctrlPres instancia del Controlador de la Capa de Presentacio
	 * @param vistaPres instancia de la Vista de la Capa de Presentacio
	 * @param maxFila maxim numero de files del local
	 * @param maxColumna maxim numero de columnes del local
	 * @param seientsLliures seients disponibles del local
	 * @param numEsp num. d'entrades que es volen comprar
	 */
	public PanellSeients(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, int maxFila, int maxColumna,
			List<TuplaSeient> seientsLliures, int numEsp) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		this.numEsp = numEsp;
		initComponents(maxFila, maxColumna, seientsLliures);
		this.setVisible(true);
	}

	/**
	 * Inicialitza els components visuals del panell i els seus comportaments
	 * @param maxFila maxim numero de files del local
	 * @param maxColumna maxim numero de columnes del local
	 * @param seientsLliures seients disponibles del local
	 */
	private void initComponents(int maxFila, int maxColumna, List<TuplaSeient> seientsLliures) {
		JLabel label1 = new JLabel("Selecciona ");
		JLabel label2 = new JLabel("");
		JLabel label3 = new JLabel(" seients");
		label1.setFont(new Font("originalfont", Font.BOLD, 14));
		label2.setFont(new Font("originalfont", Font.BOLD, 14));
		label3.setFont(new Font("originalfont", Font.BOLD, 14));
		canvas = new MyCanvas(vistaPres.getWidth(), vistaPres.getHeight(), maxFila, maxColumna, seientsLliures);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				canvas.refresh(x, y);
				label2.setText(String.valueOf(numEsp - canvas.getSeientsAssignats().size()));
			}
		});
		this.add(canvas, BorderLayout.CENTER);

		label2.setText(String.valueOf(numEsp - canvas.getSeientsAssignats().size()));

		btnContinua = new javax.swing.JButton();
		btnContinua.setText("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prContinua();
			}
		});

		btnCancela = new javax.swing.JButton();
		btnCancela.setText("Cancel·la");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prCancela();
			}
		});

		JLabel labelEspec = new JLabel("Espectacles");
		JLabel labelRepres = new JLabel("Representació");
		JLabel labelSeients = new JLabel("Seients");
		labelSeients.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
		Font font = labelSeients.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		labelSeients.setFont(font.deriveFont(attributes));
		JLabel labelPagam = new JLabel("Pagament");
		JLabel labelConfirm = new JLabel("Confirmació");
		JLabel labelSep1 = new JLabel(">>");
		JLabel labelSep2 = new JLabel(">>");
		JLabel labelSep3 = new JLabel(">>");
		JLabel labelSep4 = new JLabel(">>");

		setLayout(new GridBagLayout());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.CENTER,
						layout.createSequentialGroup().addGap(200, 200, 200).addComponent(btnContinua)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCancela).addGap(200, 200, 200))

				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(200).addComponent(label1).addComponent(label2)
								.addComponent(label3)))

				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addGroup(layout
						.createSequentialGroup().addComponent(labelEspec)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labelSep1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(labelRepres)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(labelSep2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(labelSeients)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(labelSep3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(labelPagam)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(labelSep4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(labelConfirm))
						.addGap(52, 109, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(50)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelEspec)
								.addComponent(labelRepres).addComponent(labelSeients).addComponent(labelPagam)
								.addComponent(labelConfirm).addComponent(labelSep1).addComponent(labelSep2)
								.addComponent(labelSep3).addComponent(labelSep4))
				.addGap(45)
				.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(label1).addComponent(label2)
						.addComponent(label3)).addGap(418)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnContinua)
						.addComponent(btnCancela)).addContainerGap()));
		this.setLayout(layout);
	}

	/**
	 * S'acciona quan es prem el boto Continua al panell. La seva accio es la
	 * d'avaluar els components del panell i la de mostrar el panell de Pagament
	 */
	private void prContinua() {
		List<TuplaSeient> seientsAssignats = canvas.getSeientsAssignats();

		if (numEsp - seientsAssignats.size() > 0) {
			vistaPres.mostraMissatgeEndarrera("Encara queden seients per seleccionar");
			return;
		} else if (numEsp - seientsAssignats.size() < 0) {
			vistaPres.mostraMissatgeEndarrera("S'han seleccionat més seients que el número d'espectadors");
			return;
		}

		ctrlPres.prContSeleccionarSeients(seientsAssignats);
	}

	/**
	 * S'acciona quan es prem el boto Cancel·la al panell. La seva accio es la
	 * de cancelar el flux de l'aplicacio
	 */
	private void prCancela() {
		ctrlPres.prCancela();
	}
}
