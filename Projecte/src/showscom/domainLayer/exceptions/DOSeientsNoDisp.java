package showscom.domainLayer.exceptions;

/**
 * Classe de gesti� d'Excepcions. Gestiona l'excepci� que el nombre
 * d'espectadors �s m�s gran que el nombre de seients lliures.
 */
public class DOSeientsNoDisp extends Exception {
	public static final long serialVersionUID = 1L;

	/**
	 * M�tode creador de la classe que invoca a la constructora de la classe
	 * Exception
	 */
	public DOSeientsNoDisp() {
		super();
	}
}
