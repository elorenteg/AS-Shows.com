package showscom.PresentationLayer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanellInici extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	
	private JPanel panel;
	private JLabel label;
	private JButton btnContinua;
	private JButton btnCancela;

	public PanellInici(CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setVisible(true);
		System.out.println("hola");
	}
		
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {
		panel = new JPanel();
		
        label = new javax.swing.JLabel();
        label.setText("Sistema de compra d'entrades");
        
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
		
		setLayout(new GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(label)
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnContinua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancela)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinua)
                    .addComponent(btnCancela))
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
