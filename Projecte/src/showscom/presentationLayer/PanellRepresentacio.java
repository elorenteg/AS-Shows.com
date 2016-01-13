package showscom.presentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import showscom.domainLayer.domainModel.Moneda;
import showscom.domainLayer.domainModel.TipusSessio;
import showscom.domainLayer.domainModel.TuplaRepr;

/**
 * Controla la visualitzacio grafica del Panell de Representacions
 */
public class PanellRepresentacio extends JPanel {
	private static final long serialVersionUID = 1L;

	// Instancia del Controlador de la Capa de Domini
	CtrlPresComprarEntrada ctrlPres;
	// Instancia de la Vista de la Capa de Presentacio
	VistaComprarEntrada vistaPres;

	// Instancia del boto Continua al panell
	private JButton btnContinua;
	// Instancia del boto Cancel·la al panell
	private JButton btnCancela;

	// ScrollPane on se situa la llista de representacions
	private JScrollPane scrollPane;
	// Llista amb la informacio de les representacions
	private JTable table;
	// TextField per indicar el num. d'entrades a comprar
	private JTextField textField;

	// Num. d'espectadors de l'entrada a comprar
	private int numEsp;
	// Moneda del preu de les representacions
	private Moneda divisa;

	/**
	 * Constructora del Panell de Representacions. Inicialitza la visualizacio
	 * grafica del panell i els seus atributs i comportaments
	 * @param ctrlPres instancia del Controlador de la Capa de Presentacio
	 * @param vistaPres instancia de la Vista de la Capa de Presentacio
	 * @param infoRepr llista de les representacions a mostrar
	 * @param divisa moneda en la que estan els preus de les representacions
	 */
	public PanellRepresentacio(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, List<TuplaRepr> infoRepr,
			Moneda divisa) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		this.divisa = divisa;
		initComponents(infoRepr);
		this.setVisible(true);
	}

	/**
	 * Inicialitza els components visuals del panell i els seus comportaments
	 * @param infoRepr llista de les representacions a mostrar
	 */
	private void initComponents(List<TuplaRepr> infoRepr) {
		JLabel label1 = new JLabel("Selecciona una representacio");

		scrollPane = new JScrollPane();
		Collections.sort(infoRepr, new Comparator<TuplaRepr>() {
			@Override
			public int compare(TuplaRepr p1, TuplaRepr p2) {
				if (p1.getLocal() == p2.getLocal()) {
					boolean b = TipusSessio.valueOf(p1.getSessio()).ordinal() < TipusSessio.valueOf(p2.getSessio())
							.ordinal();
					return (b) ? 1 : 0;
				} else
					return (int) p1.getLocal().compareTo(p2.getLocal());
			}
		});
		String[] columnNames = { "Local", "Sessio", "Seients", "Estrena", "Preu" };
		Object[][] data = new Object[infoRepr.size()][5];
		for (int i = 0; i < infoRepr.size(); ++i) {
			TuplaRepr tupla = infoRepr.get(i);
			data[i][0] = tupla.getLocal();
			data[i][1] = tupla.getSessio().substring(0, 1).toUpperCase() + tupla.getSessio().substring(1).toLowerCase();
			data[i][2] = tupla.getNombreSeientsLliures();

			data[i][3] = (String) (tupla.getEsEstrena() ? "\u2713" : "\u2717");
			data[i][4] = tupla.getPreu() + (String) (tupla.getEsEstrena() ? " (+" + tupla.getRecarrec() + ") " : " ")
					+ divisa.getSymbol();
		}
		table = new JTable(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		Color headerColor = Color.decode("#99B4D1");
		JTableHeader header = table.getTableHeader();
		header.setBackground(headerColor);
		header.setFont(new Font("originalfont", Font.BOLD, 12));
		table.setShowGrid(false);
		Color separatorColor = Color.decode("#C0C0C0");
		table.setGridColor(separatorColor);
		scrollPane.setViewportView(table);
		scrollPane.setMaximumSize(new Dimension(650, 280));
		scrollPane.setMinimumSize(new Dimension(650, 280));

		for (int i = 0; i < table.getColumnCount(); ++i) {
			int w;
			if (columnNames[i] == "Local")
				w = 6;
			else
				w = 1;

			table.getColumnModel().getColumn(i).setPreferredWidth(300 / 10 * w);
			table.getColumnModel().getColumn(i).setWidth(300 / 10 * w);

			if (columnNames[i] != "Local" && columnNames[i] != "Sessio") {
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
		}

		JLabel label2 = new JLabel("Num. d'espectadors:");
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(100, 20));
		textField.setMinimumSize(new Dimension(100, 20));

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
		JLabel labelRepres = new JLabel("Representacio");
		labelRepres.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
		JLabel labelSeients = new JLabel("Seients");
		JLabel labelPagam = new JLabel("Pagament");
		JLabel labelConfirm = new JLabel("Confirmacio");
		JLabel labelSep1 = new JLabel(">>");
		JLabel labelSep2 = new JLabel(">>");
		JLabel labelSep3 = new JLabel(">>");
		JLabel labelSep4 = new JLabel(">>");

		setLayout(new GridBagLayout());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.CENTER,
						layout.createSequentialGroup().addGap(200, 200, 200).addComponent(btnContinua)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCancela).addGap(200, 200, 200))

				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
						.addGroup(layout.createSequentialGroup().addComponent(label1).addGap(480, 480, 480))
						.addGap(52, 109, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(scrollPane))
						.addGroup(layout.createSequentialGroup().addComponent(label2).addGap(20, 20, 20)
								.addComponent(textField)))

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
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(50, 50, 50)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(labelEspec).addComponent(labelRepres).addComponent(labelSeients)
								.addComponent(labelPagam).addComponent(labelConfirm).addComponent(labelSep1)
								.addComponent(labelSep2).addComponent(labelSep3).addComponent(labelSep4))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addComponent(label1).addGap(10, 10, 10)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(scrollPane))
				.addGap(10, 10, 10)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(label2)
						.addComponent(textField))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnContinua).addComponent(btnCancela)).addGap(50, 50, 50).addContainerGap()));
	}

	/**
	 * S'acciona quan es prem el boto Continua al panell. La seva accio es la
	 * d'avaluar els components del panell i la de mostrar el panell de Seients
	 */
	private void prContinua() {
		String local = null;
		String sessio = null;
		numEsp = -1;

		int selRow = table.convertRowIndexToModel(table.getSelectedRow());
		try {
			local = (String) table.getModel().getValueAt(selRow, 0);
			sessio = ((String) table.getModel().getValueAt(selRow, 1)).toUpperCase();
		} catch (Exception e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha seleccionat cap representacio");
			return;
		}

		try {
			numEsp = Integer.parseInt(textField.getText());
			if (numEsp < 1)
				throw new Exception();
		} catch (Exception e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduït un nombre d'espectadors valid");
			return;
		}

		ctrlPres.prContObteOcupacio(local, sessio, numEsp);
	}

	/**
	 * S'acciona quan es prem el boto Cancel·la al panell. La seva accio es la
	 * de cancel·lar el flux de l'aplicacio
	 */
	private void prCancela() {
		ctrlPres.prCancela();
	}

	/**
	 * Consultora del num d'espectadors a comprar
	 * @return num. d'espectadors
	 */
	public int getNumEsp() {
		return numEsp;
	}

	/**
	 * Consultora de la divisa dels preus del sistema
	 * @return
	 */
	public Moneda getDivisa() {
		return divisa;
	}
}
