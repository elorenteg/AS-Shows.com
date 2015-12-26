package showscom.PresentationLayer;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanellEspectacle extends JPanel {
	private CtrlPresComprarEntrada ctrlPres;
	
	private JPanel panel;
	private JLabel label;
	private JButton btnContinua;
	private JButton btnCancela;

	public PanellEspectacle(CtrlPresComprarEntrada ctrlPres) {
		this.ctrlPres = ctrlPres;
		initComponents();
		this.setVisible(true);
		System.out.println("hola");
	}
		
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {
		panel = new JPanel();
		// jCalendar
        btnContinua = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
		
		setLayout(new GridBagLayout());

        btnContinua.setText("Continua");
        btnCancela.setText("Cancel·la");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinua)
                    .addComponent(btnCancela))
                .addContainerGap())
        );
    }
}
