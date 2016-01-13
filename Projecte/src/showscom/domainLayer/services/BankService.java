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
	 * Realitza la transferència de la quantitat monetaria establerta del compte
	 * bancari del comprador al de l'agrupació
	 * 
	 * @param dni dni del comprador de l'entrada
	 * @param codiB codi del banc del comprador
	 * @param numCompte número de compte bancari del comprador
	 * @param preu quantitat monetària a transferir
	 * @param codiBShows codi del banc de l'agrupació
	 * @param numCompteShows número de compte bancari de l'agrupació
	 * @param dAvui data de realització de la transferencia
	 * @return true si s'ha autoritzat la transferència, false altrament
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) {
		return true;
	}

}
