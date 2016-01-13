package showscom.domainLayer.serviceLocator;

import showscom.domainLayer.services.BankService;
import showscom.domainLayer.services.CurrencyConvertor;
import showscom.domainLayer.services.Service;

/**
 * Gestiona la creacio dels serveis
 */
public class ServiceLocator {
	// Instancia del ServiceLocator
	private static ServiceLocator instance = new ServiceLocator();
	// Instancia del BankService
	private static BankService bank;
	// Instancia del CurrencyConvertor
	private static CurrencyConvertor conv;

	/**
	 * Constructor per defecte privat. Evita que altres classes puguin instanciar
	 * la classe
	 */
	private ServiceLocator() {
	}

	/**
	 * Consulta la instància del ServiceLocator
	 * @return instància de ServiceLocator
	 */
	public static ServiceLocator getInstance() {
		return instance;
	}

	/**
	 * Consulta la instància d'un servei
	 * @param serviceName el nom del servei
	 * @return instancia del servei demanat
	 */
	public static Service find(String serviceName) {
		if (serviceName.equals("BankService")) {
			if (bank == null)
				bank = new BankService();
			return (Service) bank;
		} else if (serviceName.equals("CurrencyConvertor")) {
			if (conv == null)
				conv = new CurrencyConvertor();
			return (Service) conv;
		}

		return null;
	}

}
