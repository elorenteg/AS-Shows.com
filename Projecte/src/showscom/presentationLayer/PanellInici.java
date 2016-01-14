package showscom.presentationLayer;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Controla la visualitzacio grafica del Panell Inicial
 */
public class PanellInici extends JPanel {
	private static final long serialVersionUID = 1L;

	// Instancia del Controlador de la Capa de Domini
	CtrlPresComprarEntrada ctrlPres;
	// Instancia de la Vista de la Capa de Presentacio
	VistaComprarEntrada vistaPres;

	// Instancia del boto Continua al panell
	private JButton btnContinua;
	// Instancia del boto Cancel·la al panell
	private JButton btnCancela;

	/**
	 * Constructora del Panell d'Inici. Inicialitza la visualizacio grafica del
	 * panell i els seus atributs i comportaments
	 * @param ctrlPres instancia del Controlador de la Capa de Presentacio
	 * @param vistaPres instancia de la Vista de la Capa de Presentacio
	 */
	public PanellInici(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * Inicialitza els components visuals del panell i els seus comportaments
	 */
	private void initComponents() {
		JLabel label1 = new JLabel("Benvinguts al");
		label1.setFont(new Font("originalfont", Font.PLAIN, 20));
		JLabel label2 = new JLabel("Sistema de Compra d'Entrades");
		label2.setFont(new Font("originalfont", Font.PLAIN, 20));

		btnContinua = new JButton();
		btnContinua.setText("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prContinua();
			}
		});

		btnCancela = new JButton();
		btnCancela.setText("Cancel·la");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prCancela();
			}
		});

		JLabel labelEspec = new JLabel("Espectacles");
		JLabel labelRepres = new JLabel("Representacio");
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
						.addGroup(layout.createSequentialGroup().addComponent(label1)).addGap(52, 109, Short.MAX_VALUE))

				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
						.addGroup(layout.createSequentialGroup().addComponent(label2)).addGap(52, 109, Short.MAX_VALUE))

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
				.addComponent(label1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(label2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnContinua).addComponent(btnCancela)).addGap(50, 50, 50).addContainerGap()));
	}

	/**
	 * S'acciona quan es prem el boto Continua al panell. La seva accio es la de
	 * mostrar el panell d'Espectacles
	 */
	private void prContinua() {
		ctrlPres.prContObteEspectacles();
	}

	/**
	 * S'acciona quan es prem el boto Cancel·la al panell. La seva accio es la
	 * de cancelar el flux de l'aplicacio
	 */
	private void prCancela() {
		ctrlPres.prCancela();
	}
}
