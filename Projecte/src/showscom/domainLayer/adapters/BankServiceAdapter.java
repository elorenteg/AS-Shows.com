package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.BankService;

/**
 * Adapter del servei bancari per realitzar transferencies. Permet desacoblar la
 * implementacio de les operacions d'un servei extern del nostre cas d'us.
 */
public class BankServiceAdapter implements IBankServiceAdapter {

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
			Date dAvui) throws DOServeiNoDisponible {

		ServiceLocator servLoc = ServiceLocator.getInstance();
		BankService bankService = (BankService) servLoc.find("BankService");
		return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);
	}

}
