package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

/**
 * Interface del adapter del servei bancari per realitzar transferències. Ens
 * permet definir que metodes ha d'implementar qualsevol
 * CurrencyConvertorAdapter
 */
public interface IBankServiceAdapter {

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
	 * @throws DOServeiNoDisponible si no esta disponible el servei
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible;

}
