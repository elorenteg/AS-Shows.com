package showscom.presentationLayer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import showscom.domainLayer.domainModel.TuplaSeient;

public class PanellSeients extends JPanel {
	private static final long serialVersionUID = 1L;

	private CtrlPresComprarEntrada ctrlPres;
	private VistaComprarEntrada vistaPres;

	private MyCanvas canvas;

	private JButton btnContinua;
	private JButton btnCancela;

	public PanellSeients(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, int maxFila, int maxColumna,
			List<TuplaSeient> seientsLliures) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents(maxFila, maxColumna, seientsLliures);
		this.setVisible(true);
	}

	private void initComponents(int maxFila, int maxColumna, List<TuplaSeient> seientsLliures) {
		System.out.println("Max fila: " + maxFila);
		System.out.println("Max columna: " + maxColumna);
		System.out.println("Seients disp: " + seientsLliures);
		canvas = new MyCanvas(vistaPres.getWidth(), vistaPres.getHeight(), maxFila, maxColumna, seientsLliures);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				canvas.refresh(x, y);
			}
		});
		this.add(canvas, BorderLayout.CENTER);

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
		JLabel labelRepres = new JLabel("Representació");
		JLabel labelSeients = new JLabel("Seients");
		labelSeients.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
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
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnContinua).addComponent(btnCancela)).addGap(50, 50, 50).addContainerGap()));
	}

	private void prContinua(ActionEvent evt) {
		List<TuplaSeient> seientsAssignats = canvas.getSeientsAssignats();
		ctrlPres.prContSeleccionarSeients();
	}

	private void prCancela(ActionEvent evt) {
		ctrlPres.prCancela();
	}
}
