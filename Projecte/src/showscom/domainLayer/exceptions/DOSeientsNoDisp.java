package showscom.domainLayer.exceptions;

/**
 * Classe de gestió d'Excepcions. Gestiona l'excepció que el nombre
 * d’espectadors és més gran que el nombre de seients lliures.
 */
public class DOSeientsNoDisp extends Exception {
	public static final long serialVersionUID = 1L;

	/**
	 * Mètode creador de la classe que invoca a la constructora de la classe
	 * Exception
	 */
	public DOSeientsNoDisp() {
		super();
	}
}
