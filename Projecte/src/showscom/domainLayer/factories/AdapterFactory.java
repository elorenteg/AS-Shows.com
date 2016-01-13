package showscom.domainLayer.factories;

import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.CurrencyConvertorAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;

/**
 * Gestiona la creacio dels adapters per connectar-nos amb els serveis
 */
public class AdapterFactory {
	// Instancia del AdapterFactory
	private static AdapterFactory instance = new AdapterFactory();
	// Instancia del BankServiceAdapter
	private static IBankServiceAdapter bankServiceAdap;
	// Instancia del CurrencyConvertorAdapter
	private static ICurrencyConvertorAdapter currencyConvertorAdap;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin
	 * instanciar la classe. Crea els dos adapters dels serveis
	 */
	private AdapterFactory() {
		bankServiceAdap = new BankServiceAdapter();
		currencyConvertorAdap = new CurrencyConvertorAdapter();
	}

	/**
	 * Consulta la instancia del AdapterFactory
	 * @return instancia de AdapterFactory
	 */
	public static AdapterFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instancia del BankServiceAdapter
	 * @return instancia de BankServiceAdapter
	 */
	public static IBankServiceAdapter getBankServiceAdapter() {
		return bankServiceAdap;
	}

	/**
	 * Consulta la instancia del CurrencyConvertorAdapter
	 * @return instancia de CurrencyConvertorAdapter
	 */
	public static ICurrencyConvertorAdapter getCurrencyConvertorAdapter() {
		return currencyConvertorAdap;
	}

}
