package showscom.domainLayer.factories;

import showscom.domainLayer.adapters.BankServiceAdapter;
import showscom.domainLayer.adapters.CurrencyConvertorAdapter;
import showscom.domainLayer.adapters.IBankServiceAdapter;
import showscom.domainLayer.adapters.ICurrencyConvertorAdapter;

/**
 * Gestiona la creació dels adapters per connectar-nos amb els serveis
 *
 */
public class AdapterFactory {
	/**
	 * Instancia del AdapterFactory
	 */
	private static AdapterFactory instance = new AdapterFactory();

	/**
	 * Instancia del BankServiceAdapter
	 */
	private static IBankServiceAdapter bankServiceAdap;

	/**
	 * Instancia del CurrencyConvertorAdapter
	 */
	private static ICurrencyConvertorAdapter currencyConvertorAdap;

	/**
	 * Mètode creador de la classe que crea els dos adapters dels serveis
	 */
	private AdapterFactory() {
		bankServiceAdap = new BankServiceAdapter();
		currencyConvertorAdap = new CurrencyConvertorAdapter();
	}

	/**
	 * Consulta la instància del AdapterFactory
	 * 
	 * @return instància de AdapterFactory
	 */
	public static AdapterFactory getInstance() {
		return instance;
	}

	/**
	 * Consulta la instància del BankServiceAdapter
	 * 
	 * @return instància de BankServiceAdapter
	 */
	public static IBankServiceAdapter getBankServiceAdapter() {
		return bankServiceAdap;
	}

	/**
	 * Consulta la instància del CurrencyConvertorAdapter
	 * 
	 * @return instància de CurrencyConvertorAdapter
	 */
	public static ICurrencyConvertorAdapter getCurrencyConvertorAdapter() {
		return currencyConvertorAdap;
	}

}
