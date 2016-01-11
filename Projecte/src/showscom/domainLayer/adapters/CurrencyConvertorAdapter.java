package showscom.domainLayer.adapters;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.CurrencyConvertor;

public class CurrencyConvertorAdapter implements ICurrencyConvertorAdapter {

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
