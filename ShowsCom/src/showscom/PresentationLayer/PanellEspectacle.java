package showscom.PresentationLayer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanellEspectacle extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	
	private JPanel panel;
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

	public PanellEspectacle(CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setVisible(true);
	}
		
	@SuppressWarnings("unchecked")                       
	private void initComponents() {
		panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		String[] stringArray = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		JList list = new JList(stringArray);
		scrollPane.setViewportView(list);
		scrollPane.setMaximumSize(new Dimension(250, 280));
		scrollPane.setMinimumSize(new Dimension(250, 280));
        
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
        
        labelEspec = new JLabel(); labelEspec.setText("Espectacles"); labelEspec.setFont(new Font("originalfont", Font.ITALIC | Font.BOLD, 12));
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
                    .addComponent(scrollPane))
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
                .addComponent(scrollPane)
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
