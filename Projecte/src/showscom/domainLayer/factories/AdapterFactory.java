package showscom.domainLayer.factories;

import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.CurrencyConvertorAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;

public class AdapterFactory {
	private static AdapterFactory instance = new AdapterFactory();
	private static IBankServiceAdapter bankServiceAdap;
	private static ICurrencyConvertorAdapter currencyConvertorAdap;

	private AdapterFactory() {
		bankServiceAdap = new BankServiceAdapter();
		currencyConvertorAdap = new CurrencyConvertorAdapter();
	}

	public static AdapterFactory getInstance() {
		return instance;
	}

	public static IBankServiceAdapter getBankServiceAdapter() {
		return bankServiceAdap;
	}

	public static ICurrencyConvertorAdapter getCurrencyConvertorAdapter() {
		return currencyConvertorAdap;
	}

}
