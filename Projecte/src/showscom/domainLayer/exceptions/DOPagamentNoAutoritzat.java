package showscom.domainLayer.exceptions;

/**
 * Classe de gestió d'Excepcions. Gestiona l'excepció de pagament no autoritzat.
 */
public class DOPagamentNoAutoritzat extends Exception {
	public static final long serialVersionUID = 1L;

	/**
	 * Mètode creador de la classe que invoca a la constructora de la classe
	 * Exception
	 */
	public DOPagamentNoAutoritzat() {
		super();
	}
}
