package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

/**
 * Interface del adapter del servei bancari per realitzar transferencies. Ens
 * permet definir que metodes ha d'implementar qualsevol
 * CurrencyConvertorAdapter
 */
public interface IBankServiceAdapter {

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
	 * @throws DOServeiNoDisponible si no esta disponible el servei
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible;

}
