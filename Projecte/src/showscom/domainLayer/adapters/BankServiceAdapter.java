package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.BankService;

/**
 * Adapter del servei bancari per realitzar transfer�ncies. Permet desacoblar la
 * implementaci� de les operacions d�un servei extern del nostre cas d��s.
 */
public class BankServiceAdapter implements IBankServiceAdapter {

	/**
	 * Realitza la transfer�ncia de la quantitat monetaria establerta del compte
	 * bancari del comprador al de l'agrupaci�
	 * @param dni DNI del comprador de l'entrada
	 * @param codiB codi del banc del comprador
	 * @param numCompte n�mero de compte bancari del comprador
	 * @param preu quantitat monet�ria a transferir
	 * @param codiBShows codi del banc de l'agrupaci�
	 * @param numCompteShows n�mero de compte bancari de l'agrupaci�
	 * @param dAvui data de realitzaci� de la transferencia
	 * @return true si s'ha autoritzat la transfer�ncia, false altrament
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible {

		ServiceLocator servLoc = ServiceLocator.getInstance();
		BankService bankService = (BankService) servLoc.find("BankService");
		return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);
	}

}
