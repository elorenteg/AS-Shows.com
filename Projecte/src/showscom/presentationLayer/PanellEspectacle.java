package showscom.presentationLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class PanellEspectacle extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	private VistaComprarEntrada vistaPres;

	private JButton btnContinua;
	private JButton btnCancela;

	private JScrollPane scrollPane;
	private JTable table;
	private JDatePanelImpl datePanel;

	public PanellEspectacle(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, List<String> espectacles) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents(espectacles);
		this.setVisible(true);
	}

	@SuppressWarnings("serial")
	private void initComponents(List<String> espectacles) {
		JLabel label1 = new JLabel("Selecciona un espectacle i una data");

		scrollPane = new JScrollPane();
		String[] columnNames = { "Títols" };
		Object[][] data = new Object[espectacles.size()][1];
		for (int i = 0; i < espectacles.size(); ++i) {
			data[i][0] = espectacles.get(i);
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
		scrollPane.setMaximumSize(new Dimension(250, 280));
		scrollPane.setMinimumSize(new Dimension(250, 280));
		// scrollPane.setBorder(BorderFactory.createEmptyBorder());

		UtilDateModel model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePanel.setMaximumSize(new Dimension(200, 50));

		btnContinua = new javax.swing.JButton();
		btnContinua.setText("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prContinua(evt);
			}
		});

		btnCancela = new javax.swing.JButton();
		btnCancela.setText("Cancel·la");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prCancela(evt);
			}
		});

		JLabel labelEspec = new JLabel("Espectacles");
		labelEspec.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
		JLabel labelRepres = new JLabel("Representació");
		JLabel labelSeients = new JLabel("Seients");
		JLabel labelPagam = new JLabel("Pagament");
		JLabel labelConfirm = new JLabel("Confirmació");
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
						.addGroup(layout.createSequentialGroup().addComponent(label1).addGap(420, 420, 420))
						.addGap(52, 109, Short.MAX_VALUE).addGroup(layout.createSequentialGroup()
								.addComponent(scrollPane).addGap(170, 170, 170).addComponent(datePanel)))

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
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(scrollPane)
						.addComponent(datePanel))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnContinua).addComponent(btnCancela)).addGap(50, 50, 50).addContainerGap()));
	}

	private void prContinua(ActionEvent evt) {
		String titol = null;
		Date data = null;
		int selRow = table.convertRowIndexToModel(table.getSelectedRow());
		try {
			titol = (String) table.getModel().getValueAt(selRow, 0);
		} catch (Exception e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha seleccionat cap espectacle");
			return;
		}

		Date dateRaw = (Date) datePanel.getModel().getValue();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String dataString = df.format(dateRaw);
			data = df.parse(dataString);
		} catch (NullPointerException e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha seleccionat cap data");
			return;
		} catch (ParseException e) { // No hauria de passar
			vistaPres.mostraMissatgeEndarrera("No s'ha seleccionat cap data - Parse error");
			return;
		}

		Instant instant = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date dAvui = Date.from(instant);
		if (data.before(dAvui)) {
			vistaPres.mostraMissatgeEndarrera("La data selecciona no és vàlida");
			return;
		}

		ctrlPres.prContObteRepresentacions(titol, data);
	}

	private void prCancela(ActionEvent evt) {
		ctrlPres.prCancela();
	}
}
