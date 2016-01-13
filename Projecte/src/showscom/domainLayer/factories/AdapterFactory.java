package showscom.domainLayer.factories;

import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.CurrencyConvertorAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;

/**
 * Gestiona la creaci� dels adapters per connectar-nos amb els serveis
 */
public class AdapterFactory {
	// Instancia del AdapterFactory
	private static AdapterFactory instance = new AdapterFactory();
	// Instancia del BankServiceAdapter
	private static IBankServiceAdapter bankServiceAdap;
	// Instancia del CurrencyConvertorAdapter
	private static ICurrencyConvertorAdapter currencyConvertorAdap;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin instanciar
	 * la classe. Crea els dos adapters dels serveis
	 */
	private AdapterFactory() {
		bankServiceAdap = new BankServiceAdapter();
		currencyConvertorAdap = new CurrencyConvertorAdapter();
	}

	/**
	 * Consulta la inst�ncia del AdapterFactory
	 * @return inst�ncia de AdapterFactory
	 */
	public static AdapterFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la inst�ncia del BankServiceAdapter
	 * @return inst�ncia de BankServiceAdapter
	 */
	public static IBankServiceAdapter getBankServiceAdapter() {
		return bankServiceAdap;
	}

	/**
	 * Consulta la inst�ncia del CurrencyConvertorAdapter
	 * @return inst�ncia de CurrencyConvertorAdapter
	 */
	public static ICurrencyConvertorAdapter getCurrencyConvertorAdapter() {
		return currencyConvertorAdap;
	}

}
