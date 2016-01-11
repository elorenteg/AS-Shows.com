package showscom.domainLayer.adapters;

import showscom.domainLayer.domainModel.Moneda;

public interface ICurrencyConvertorAdapter {

	public float conversorRate(String divisa, String moneda);

}
