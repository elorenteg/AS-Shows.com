package showscom.domainLayer.services;

import java.util.Date;
import java.util.Random;

/**
 * Servei bancari per realitzar transferencies
 */
public class BankService implements Service {
	// Nom del servei
	private static final String name = "BankService";

	// Generador de nombres random
	private Random random = new Random();

	/**
	 * Consulta el nom del servei
	 * @return nom del servei
	 */
	public String getName() {
		return name;
	}

	/**
	 * Realitza la transferencia de la quantitat monetaria establerta del compte
	 * bancari del comprador al de l'agrupacio
	 * @param dni DNI del comprador de l'entrada
	 * @param codiB codi del banc del comprador
	 * @param numCompte numero de compte bancari del comprador
	 * @param preu quantitat monetaria a transferir
	 * @param codiBShows codi del banc de l'agrupacio
	 * @param numCompteShows numero de compte bancari de l'agrupacio
	 * @param dAvui data de realitzacio de la transferencia
	 * @return true si s'ha autoritzat la transferencia, false altrament
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) {
		return random.nextBoolean();
		//return true;
	}

}
