package showscom.domainLayer.services;

import java.util.Date;

public class BankService implements Service {
	// nom del servei
	private static final String name = "BankService";

	/**
	 * Consulta el nom del servei
	 * 
	 * @return nom del servei
	 */
	public String getName() {
		return name;
	}

	/**
	 * Realitza la transfer�ncia de la quantitat monetaria establerta del compte
	 * bancari del comprador al de l'agrupaci�
	 * 
	 * @param dni dni del comprador de l'entrada
	 * @param codiB codi del banc del comprador
	 * @param numCompte n�mero de compte bancari del comprador
	 * @param preu quantitat monet�ria a transferir
	 * @param codiBShows codi del banc de l'agrupaci�
	 * @param numCompteShows n�mero de compte bancari de l'agrupaci�
	 * @param dAvui data de realitzaci� de la transferencia
	 * @return true si s'ha autoritzat la transfer�ncia, false altrament
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) {
		return true;
	}

}
