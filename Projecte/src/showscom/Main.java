package showscom;

import showscom.presentationLayer.CtrlPresComprarEntrada;

/**
 * Programa principal
 */
public class Main {

	/**
	 * Funcio principal que crida al Ctrl de Presentacio per executar el Cas
	 * d'Us de Compra d'Entrades
	 * @param args Command-Line Arguments
	 */
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CtrlPresComprarEntrada();
			}
		});
	}
}
