package showscom.domainLayer.adapters;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

/**
 * Interface del adapter del servei de canvi de divisa per a realitzar el pagament. Ens permet
 * definir que metodes ha d'implementar qualsevol CurrencyConvertorAdapter
 */
public interface ICurrencyConvertorAdapter {

	/**
	 * Obt� la conversi� d'una divisa a una altra
	 * @param from divisa que volem canviar
	 * @param to divisa a la que volem canviar
	 * @return conversi� de les divises
	 * @throws Exception si no s'ha trobat el servei o la resposta �s err�nia
	 */
	public float conversorRate(String divisa, String moneda) throws DOServeiNoDisponible;

}
