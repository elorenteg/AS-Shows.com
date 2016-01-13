package showscom.presentationLayer;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Controla la visualitzacio grafica del Panell de Finalitzacio
 */
public class PanellFi extends JPanel {
	private static final long serialVersionUID = 1L;

	// Instancia del Controlador de la Capa de Domini
	CtrlPresComprarEntrada ctrlPres;
	// Instancia de la Vista de la Capa de Presentacio
	VistaComprarEntrada vistaPres;

	// Instancia del boto de Finalitzacio del Panell de Finalitzacio
	private JButton btnFinalitza;

	/**
	 * Constructora del Panell de Finalitzacio. Inicialitza la visualizacio
	 * grafica del panell i els seus atributs i comportaments
	 * @param ctrlPres instancia del Controlador de la Capa de Presentacio
	 * @param vistaPres instancia de la Vista de la Capa de Presentacio
	 */
	public PanellFi(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents();
		this.setVisible(true);
	}

	/**
	 * Inicialitza els components visuals del panell i els seus comportaments
	 */
	private void initComponents() {
		JLabel label1 = new JLabel();
		label1.setText("Pagament realitzat correctament");
		label1.setFont(new Font("originalfont", Font.PLAIN, 16));
		JLabel label2 = new JLabel();
		label2.setText("Podra recollir les seves entrades a la seva entitat bancaria");
		label2.setFont(new Font("originalfont", Font.PLAIN, 16));

		btnFinalitza = new javax.swing.JButton();
		btnFinalitza.setText("Finalitza");
		btnFinalitza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prFinalitza();
			}
		});

		JLabel labelEspec = new JLabel();
		labelEspec.setText("Espectacles");
		JLabel labelRepres = new JLabel();
		labelRepres.setText("Representacio");
		JLabel labelSeients = new JLabel();
		labelSeients.setText("Seients");
		JLabel labelPagam = new JLabel();
		labelPagam.setText("Pagament");
		JLabel labelConfirm = new JLabel();
		labelConfirm.setText("Confirmacio");
		JLabel labelSep1 = new JLabel();
		labelSep1.setText(">>");
		JLabel labelSep2 = new JLabel();
		labelSep2.setText(">>");
		JLabel labelSep3 = new JLabel();
		labelSep3.setText(">>");
		JLabel labelSep4 = new JLabel();
		labelSep4.setText(">>");

		setLayout(new GridBagLayout());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.CENTER,
				layout.createSequentialGroup().addGap(200, 200, 200).addComponent(btnFinalitza).addGap(200, 200, 200))

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
						.addComponent(btnFinalitza)).addGap(50, 50, 50).addContainerGap()));
	}

	/**
	 * S'acciona quan es prem el boto Finalitza al panell. La seva accio es la
	 * de tancar l'aplicacio
	 */
	private void prFinalitza() {
		ctrlPres.prFinalitza();
	}
}
