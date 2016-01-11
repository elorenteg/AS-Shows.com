package showscom.domainLayer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConvertor implements Service {
	private static final String name = "CurrencyConvertor";

	public String getName() {
		return name;
	}

	/*
	 * public float conversorRateEXT(String from, String to) throws
	 * CurrencyConverterException {
	 * 
	 * CurrencyConverter currencyConverter; try { currencyConverter = new
	 * BankUaCom(Currency.valueOf(from), Currency.valueOf(to)); return
	 * currencyConverter.convertCurrency(1f); } catch
	 * (CurrencyConverterException e) { throw e; } }
	 */

	public float conversorRate(String from, String to) throws Exception {
		try {
			URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + from + to + "=X&f=l1&e=.cs");
			//URL url2 = new URL("https://www.google.com/finance/converter?a=1&=" + from + "&to=" + to);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			if (line.length() > 0) {
				return Float.parseFloat(line);
			} else
				throw new Exception();
		} catch (IOException | NumberFormatException e) {
			throw e;
		}
	}
}
