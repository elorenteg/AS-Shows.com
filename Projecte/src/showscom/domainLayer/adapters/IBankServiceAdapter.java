package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

/**
 * Interface del adapter del servei bancari per realitzar transfer�ncies. Ens
 * permet definir que metodes ha d'implementar qualsevol
 * CurrencyConvertorAdapter
 */
public interface IBankServiceAdapter {

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
	 * @throws DOServeiNoDisponible si no esta disponible el servei
	 */
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible;

}
