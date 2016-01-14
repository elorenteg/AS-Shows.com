package showscom.domainLayer.adapters;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.CurrencyConvertor;

/**
 * Adapter del servei de canvi de divisa per a realitzar el pagament. Permet
 * desacoblar la implementacio de les operacions d'un servei extern del nostre
 * cas d'us.
 */
public class CurrencyConvertorAdapter implements ICurrencyConvertorAdapter {

	/**
	 * Obte la conversio d'una divisa a una altra
	 * @param divisa divisa que volem canviar
	 * @param moneda divisa a la que volem canviar
	 * @return conversio de les divises
	 * @throws DOServeiNoDisponible si no s'ha trobat el servei o la resposta es
	 *         erronia
	 */
	public float conversorRate(String divisa, String moneda) throws DOServeiNoDisponible {
		ServiceLocator servLoc = ServiceLocator.getInstance();
		CurrencyConvertor curConv = (CurrencyConvertor) servLoc.find("CurrencyConvertor");
		float conversio = -1;
		try {
			conversio = curConv.conversorRate(divisa, moneda);
		} catch (Exception e) {
			throw new DOServeiNoDisponible();
		}

		return conversio;
	}

}
