package showscom.domainLayer.exceptions;

/**
 * Classe de gestio d'Excepcions. Gestiona l'excepcio que el nombre
 * d'espectadors es mes gran que el nombre de seients lliures.
 */
public class DOSeientsNoDisp extends Exception {
	public static final long serialVersionUID = 1L;

	/**
	 * Metode creador de la classe que invoca a la constructora de la classe
	 * Exception
	 */
	public DOSeientsNoDisp() {
		super();
	}
}
