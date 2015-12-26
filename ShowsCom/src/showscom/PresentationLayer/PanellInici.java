package showscom.PresentationLayer;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanellInici extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JButton btnContinua;
	private JButton btnCancela;
	
	private JLabel labelEspec;
    private JLabel labelRepres;
    private JLabel labelSeients;
    private JLabel labelPagam;
    private JLabel labelConfirm;
    private JLabel labelSep1;
    private JLabel labelSep2;
    private JLabel labelSep3;
    private JLabel labelSep4;

	public PanellInici(CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setVisible(true);
	}
		
	@SuppressWarnings("unchecked")                       
	private void initComponents() {
		panel = new JPanel();
		
        label1 = new JLabel(); label1.setText("Benvinguts al"); label1.setFont(new Font("originalfont", Font.PLAIN, 20));
        label2 = new JLabel(); label2.setText("Sistema de Compra d'Entrades"); label2.setFont(new Font("originalfont", Font.PLAIN, 20));
        
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
        
        labelEspec = new JLabel(); labelEspec.setText("Espectacles");
        labelRepres = new JLabel(); labelRepres.setText("Representació");
        labelSeients = new JLabel(); labelSeients.setText("Seients");
        labelPagam = new JLabel(); labelPagam.setText("Pagament");
        labelConfirm = new JLabel(); labelConfirm.setText("Confirmació");
        labelSep1 = new JLabel(); labelSep1.setText(">>");
        labelSep2 = new JLabel(); labelSep2.setText(">>");
        labelSep3 = new JLabel(); labelSep3.setText(">>");
        labelSep4 = new JLabel(); labelSep4.setText(">>");
        
		setLayout(new GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
    		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnContinua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancela)
                .addGap(200, 200, 200))

            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
                    .addComponent(label1))
        		.addGap(52, 109, Short.MAX_VALUE))

            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
                    .addComponent(label2))
        		.addGap(52, 109, Short.MAX_VALUE))

            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(labelEspec)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelSep1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelRepres)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelSep2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelSeients)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelSep3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelPagam)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(labelSep4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelConfirm))
                .addGap(52, 109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
        		.addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEspec)
                    .addComponent(labelRepres)
                    .addComponent(labelSeients)
                    .addComponent(labelPagam)
                    .addComponent(labelConfirm)
                    .addComponent(labelSep1)
                    .addComponent(labelSep2)
                    .addComponent(labelSep3)
                    .addComponent(labelSep4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnContinua)
                        .addComponent(btnCancela))
                .addGap(50, 50, 50)
                .addContainerGap())
        );
    }
	
	private void prContinua(ActionEvent evt) {
		ctrlPres.prContObteEspectacles();
	}
	
	private void prCancela(ActionEvent evt) {
		ctrlPres.prCancela();
	}
}
