package showscom.domainLayer.adapters;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

public interface ICurrencyConvertorAdapter {

	public float conversorRate(String divisa, String moneda) throws DOServeiNoDisponible;

}
