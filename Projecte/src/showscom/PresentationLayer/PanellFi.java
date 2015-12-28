package showscom.PresentationLayer;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanellFi extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	private VistaComprarEntrada vistaPres;
	
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JButton btnFinalitza;
	
	private JLabel labelEspec;
    private JLabel labelRepres;
    private JLabel labelSeients;
    private JLabel labelPagam;
    private JLabel labelConfirm;
    private JLabel labelSep1;
    private JLabel labelSep2;
    private JLabel labelSep3;
    private JLabel labelSep4;

	public PanellFi(CtrlPresComprarEntrada ctrlPres, VistaComprarEntrada vistaPres) {
		this.ctrlPres = ctrlPres;
		this.vistaPres = vistaPres;
		initComponents();
		this.setVisible(true);
	}
		
	@SuppressWarnings("unchecked")                       
	private void initComponents() {
		panel = new JPanel();
		
        label1 = new JLabel(); label1.setText("Pagament realitzat correctament"); label1.setFont(new Font("originalfont", Font.PLAIN, 16));
        label2 = new JLabel(); label2.setText("Podrà recollir les seves entrades a la seva entitat bancària"); label2.setFont(new Font("originalfont", Font.PLAIN, 16));
        
        btnFinalitza = new javax.swing.JButton();
        btnFinalitza.setText("Finalitza");
        btnFinalitza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		prFinalitza(evt);
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
                .addComponent(btnFinalitza)
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
                        .addComponent(btnFinalitza))
                .addGap(50, 50, 50)
                .addContainerGap())
        );
    }
	
	private void prFinalitza(ActionEvent evt) {
		ctrlPres.prFinalitza();
	}
}
