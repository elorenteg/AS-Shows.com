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

public class PanellPagament extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	private VistaComprarEntrada vistaPres;

	private JTextField textFieldPreu;
	private JTextField textFieldDNI;
	private JTextField textFieldCodiBanc;
	private JTextField textFieldNumCompte;
	private JButton btnContinua;
	private JButton btnCancela;
	private JComboBox<String> comboBoxDivises;

	public PanellPagament(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		// initComponents(preu, divises);
		this.setVisible(true);
	}

	public PanellPagament(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres, float preu,
			List<String> divises) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents(preu, divises);
		this.setVisible(true);
	}

	private void initComponents(float preu, List<String> divises) {

		JLabel labelPreu = new JLabel("Preu total:");
		labelPreu.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldPreu = new JTextField();
		textFieldPreu.setEditable(false);
		textFieldPreu.setText(Float.toString(preu));
		textFieldPreu.setColumns(10);

		comboBoxDivises = new JComboBox<String>();
		for (String divisa : divises)
			comboBoxDivises.addItem(divisa);

		JLabel labelDNI = new JLabel("DNI:");
		labelDNI.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);

		JLabel labelCodiBanc = new JLabel("Codi banc:");
		labelCodiBanc.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldCodiBanc = new JTextField();
		textFieldCodiBanc.setColumns(10);

		JLabel labelNumCompte = new JLabel("Núm. Compte:");
		labelNumCompte.setFont(new Font("originalfont", Font.PLAIN, 16));

		textFieldNumCompte = new JTextField();
		textFieldNumCompte.setColumns(10);

		btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prContinua(evt);
			}
		});

		btnCancela = new JButton("Cancel·la");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prCancela(evt);
			}
		});

		JLabel labelEspec = new JLabel("Espectacles");
		JLabel labelRepres = new JLabel("Representació");
		JLabel labelSeients = new JLabel("Seients");
		JLabel labelPagam = new JLabel("Pagament");
		labelPagam.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
		JLabel labelConfirm = new JLabel("Confirmació");
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

	private void prContinua(ActionEvent evt) {
		String DNI = textFieldDNI.getText();
		if (DNI == null) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el DNI");
			return;
		}
		
		DNI = DNI.replaceAll("[\\s\\-]", "");
		if (DNI.length() > 9) {
			vistaPres.mostraMissatgeEndarrera("La grandària del DNI és incorrecte");
			return;
		}
		
		int valorDNI;
		try {
			valorDNI = Integer.parseInt(DNI.substring(0, DNI.length()-1));
		} catch (NumberFormatException e) {
			vistaPres.mostraMissatgeEndarrera("El format del DNI no és correcte");
			return;
		}
		
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (letrasDNI.charAt(valorDNI%23) != DNI.charAt(DNI.length()-1)) {
			vistaPres.mostraMissatgeEndarrera("La lletra del DNI no és correcta");
			return;
		}
		
		

		int codiBanc;
		try {
			codiBanc = Integer.parseInt(textFieldCodiBanc.getText());
		} catch (NumberFormatException e) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el Codi del banc o no és vàlid");
			return;
		}
		
		

		String numCompte = textFieldNumCompte.getText();
		if (numCompte == null) {
			vistaPres.mostraMissatgeEndarrera("No s'ha introduit el Número de compte");
			return;
		}
		
		
		String newAccountNumber = numCompte.replaceAll("\\s","");
        	if (newAccountNumber.length() < 15 || newAccountNumber.length() > 34) {
        		vistaPres.mostraMissatgeEndarrera("La grandària del Número de compte és incorrecte");
			return;
        	}
        
	        newAccountNumber = newAccountNumber.substring(4) + newAccountNumber.substring(0, 4);        
	        StringBuilder numericAccountNumber = new StringBuilder();
	        for (int i = 0; i < newAccountNumber.length(); i++) {
	            	numericAccountNumber.append(Character.getNumericValue(newAccountNumber.charAt(i)));
	        }
	
	        BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());
	        if (ibanNumber.mod(new BigInteger("97")).intValue() != 1) {
	        	vistaPres.mostraMissatgeEndarrera("El Número de compte no és correcte");
			return;
	        };
		
		
		
		ctrlPres.prContPagament(DNI, codiBanc, numCompte);
	}

	private void prCancela(ActionEvent evt) {
		ctrlPres.prCancela();
	}
}
