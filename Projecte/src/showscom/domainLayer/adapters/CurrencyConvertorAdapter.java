package showscom.domainLayer.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.CurrencyConvertor;

public class CurrencyConvertorAdapter implements ICurrencyConvertorAdapter {

	public float conversorRate(String divisa, String moneda) {
		ServiceLocator servLoc = ServiceLocator.getInstance();
		CurrencyConvertor curConv = (CurrencyConvertor) servLoc.find("CurrencyConvertor");
		return curConv.conversorRate(divisa, moneda);
	}

}
