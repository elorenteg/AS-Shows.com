package showscom.domainLayer.services;

import java.io.BufferedReader;

import com.tunyk.currencyconverter.api.Currency;
import com.tunyk.currencyconverter.api.CurrencyConverterException;
import com.tunyk.currencyconverter.BankUaCom;
import com.tunyk.currencyconverter.api.CurrencyConverter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.tunyk.currencyconverter.api.CurrencyConverter;

public class CurrencyConvertor implements Service {
	private static final String name = "CurrencyConvertor";

	public String getName() {
		return name;
	}

	public float conversorRate(String from, String to) {
		CurrencyConverter currencyConverter;
		try {
			currencyConverter = new BankUaCom(Currency.valueOf(from), Currency.valueOf(to));
			return currencyConverter.convertCurrency(1f);
		} catch (CurrencyConverterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try { //URL url = new
		 * URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + from + to +
		 * "=X&f=l1&e=.cs"); URL url = new
		 * URL("https://www.google.com/finance/converter?a=1&="+from+"&to="+to);
		 * BufferedReader reader = new BufferedReader(new
		 * InputStreamReader(url.openStream())); String line =
		 * reader.readLine(); if (line.length() > 0) { return
		 * Float.parseFloat(line); } reader.close(); } catch (IOException |
		 * NumberFormatException e) { System.out.println(e.getMessage()); }
		 */
		return 0;
	}
}
