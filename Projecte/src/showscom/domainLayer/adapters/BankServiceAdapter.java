package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.BankService;

/**
 * Adapter del servei bancari per realitzar transferències. Permet desacoblar la
 * implementació de les operacions d’un servei extern del nostre cas d’ús.
 */
public class BankServiceAdapter implements IBankServiceAdapter {

	/**
	 * Realitza la transferència de la quantitat monetaria establerta del compte
	 * bancari del comprador al de l'agrupació
	 * @param dni DNI del comprador de l'entrada
	 * @param codiB codi del banc del comprador
	 * @param numCompte número de compte bancari del comprador
	 * @param preu quantitat monetària a transferir
	 * @param codiBShows codi del banc de l'agrupació
	 * @param numCompteShows número de compte bancari de l'agrupació
	 * @param dAvui data de realització de la transferencia
	 * @return true si s'ha autoritzat la transferència, false altrament
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible {

		ServiceLocator servLoc = ServiceLocator.getInstance();
		BankService bankService = (BankService) servLoc.find("BankService");
		return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);
	}

}
