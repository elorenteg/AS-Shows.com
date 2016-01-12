package showscom.presentationLayer;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import showscom.domainLayer.domainModel.Moneda;

public class PanellPagament extends JPanel {
	private static final long serialVersionUID = 1L;

	private CtrlPresComprarEntrada ctrlPres;
	private VistaComprarEntrada vistaPres;

	private JTextField textFieldPreu;
	private JTextField textFieldDNI;
	private JTextField textFieldCodiBanc;
	private JTextField textFieldNumCompte;
	private JButton btnContinua;
	private JButton btnCancela;
	private JComboBox<String> comboBoxDivises;

	private Moneda divisaAct;

	public PanellPagament(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, float preu,
			List<String> canvis, Moneda divisa) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents(preu, canvis, divisa);
		this.setVisible(true);
	}

	private void initComponents(float preu, List<String> canvis, Moneda divisa) {
		this.divisaAct = divisa;

		JLabel labelPreu = new JLabel("Preu total:");
		labelPreu.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldPreu = new JTextField();
		textFieldPreu.setEditable(false);
		actualitzaPreu(preu);
		textFieldPreu.setColumns(10);

		comboBoxDivises = new JComboBox<String>();
		comboBoxDivises.addItem(divisa.name());
		for (String canv : canvis)
			comboBoxDivises.addItem(canv);
		comboBoxDivises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Moneda selMoneda = Moneda.valueOf(comboBoxDivises.getSelectedItem().toString());
				if (divisaAct != selMoneda) {
					divisaAct = selMoneda;
					ctrlPres.prComboObtePreuMoneda(selMoneda.name());
				}
			}
		});

		JLabel labelDNI = new JLabel("DNI:");
		labelDNI.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);

		JLabel labelCodiBanc = new JLabel("Codi banc:");
		labelCodiBanc.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldCodiBanc = new JTextField();
		textFieldCodiBanc.setColumns(10);

		JLabel labelNumCompte = new JLabel("N�m. Compte:");
		labelNumCompte.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldNumCompte = new JTextField();
		textFieldNumCompte.setColumns(10);

		btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prContinua();
			}
		});

		btnCancela = new JButton("Cancel�la");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prCancela();
			}
		});

		JLabel labelEspec = new JLabel("Espectacles");
		JLabel labelRepres = new JLabel("Representaci�");
		JLabel labelSeients = new JLabel("Seients");
		JLabel labelPagam = new JLabel("Pagament");
		labelPagam.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
		JLabel labelConfirm = new JLabel("Confirmaci�");
		JLabel labelSep1 = new JLabel(">>");
		JLabel labelSep2 = new JLabel(">>");
		JLabel labelSep3 = new JLabel(">>");
		JLabel labelSep4 = new JLabel(">>");

		setLayout(new GridBagLayout());

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.CENTER,
								layout.createSequentialGroup().addGap(200)
										.addComponent(btnContinua).addPreferredGap(ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCancela).addGap(200))

						.addGroup(layout.createSequentialGroup().addGap(225)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(labelPreu).addComponent(labelDNI).addComponent(labelCodiBanc)
										.addComponent(labelNumCompte))
								.addGap(25)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(textFieldPreu).addGap(50)
												.addComponent(comboBoxDivises))
										.addComponent(textFieldDNI).addComponent(textFieldCodiBanc)
										.addComponent(textFieldNumCompte))
								.addGap(225))

						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addGroup(layout.createSequentialGroup().addComponent(labelEspec)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelSep1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelRepres)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelSep2)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelSeients)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelSep3)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelPagam)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(labelSep4)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelConfirm))
								.addGap(52, 109, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(50)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelEspec)
								.addComponent(labelRepres).addComponent(labelSeients).addComponent(labelPagam)
								.addComponent(labelConfirm).addComponent(labelSep1).addComponent(labelSep2)
								.addComponent(labelSep3).addComponent(labelSep4))
				.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelPreu)
						.addComponent(textFieldPreu).addComponent(comboBoxDivises))
				.addPreferredGap(ComponentPlacement.RELATED, 25, 25)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelDNI)
						.addComponent(textFieldDNI))
				.addPreferredGap(ComponentPlacement.RELATED, 25, 25)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelCodiBanc)
						.addComponent(textFieldCodiBanc))
				.addPreferredGap(ComponentPlacement.RELATED, 25, 25)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelNumCompte)
						.addComponent(textFieldNumCompte))
				.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnContinua)
						.addComponent(btnCancela)).addGap(50).addContainerGap()));
	}

	private void prContinua() {
		String DNI = textFieldDNI.getText();
		if (DNI == null) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el DNI");
			return;
		}

		DNI = DNI.replaceAll("[\\s\\-]", "");
		if (DNI.length() > 9) {
			vistaPres.mostraMissatgeEndarrera("La grand�ria del DNI �s incorrecte");
			return;
		}

		int valorDNI;
		try {
			valorDNI = Integer.parseInt(DNI.substring(0, DNI.length() - 1));
		} catch (NumberFormatException | StringIndexOutOfBoundsException e) {
			vistaPres.mostraMissatgeEndarrera("El format del DNI no �s correcte");
			return;
		}

		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (letrasDNI.charAt(valorDNI % 23) != DNI.charAt(DNI.length() - 1)) {
			vistaPres.mostraMissatgeEndarrera("La lletra del DNI no �s correcta");
			return;
		}

		int codiBanc;
		String aux = textFieldCodiBanc.getText();
		if (aux.length() != 4) {
			vistaPres.mostraMissatgeEndarrera("El Codi del banc ha de estar format per quatre d�gits");
			return;
		}
		try {
			codiBanc = Integer.parseInt(aux);
		} catch (NumberFormatException e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el Codi del banc o no �s v�lid");
			return;
		}

		String numCompte = textFieldNumCompte.getText();
		if (numCompte == null) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el N�mero de compte");
			return;
		}

		String newAccountNumber = numCompte.replaceAll("\\s", "");
		if (newAccountNumber.length() < 15 || newAccountNumber.length() > 34) {
			vistaPres.mostraMissatgeEndarrera("La grand�ria del N�mero de compte �s incorrecte");
			return;
		}

		newAccountNumber = newAccountNumber.substring(4) + newAccountNumber.substring(0, 4);
		StringBuilder numericAccountNumber = new StringBuilder();
		for (int i = 0; i < newAccountNumber.length(); i++) {
			numericAccountNumber.append(Character.getNumericValue(newAccountNumber.charAt(i)));
		}

		BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());
		if (ibanNumber.mod(new BigInteger("97")).intValue() != 1) {
			vistaPres.mostraMissatgeEndarrera("El N-umero de compte no �s correcte");
			return;
		}
		;

		ctrlPres.prContPagament(DNI, codiBanc, numCompte);
	}

	private void prCancela() {
		ctrlPres.prCancela();
	}

	public void actualitzaPreu(float preu) {
		textFieldPreu.setText(String.format("%.2f", preu) + " " + divisaAct.getSymbol());
	}
}
