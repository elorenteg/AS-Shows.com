package showscom.domainLayer.serviceLocator;

import showscom.domainLayer.services.BankService;
import showscom.domainLayer.services.CurrencyConvertor;
import showscom.domainLayer.services.Service;

public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator();
	private static BankService bank;
	private static CurrencyConvertor conv;

	private ServiceLocator() {
	}

	public static ServiceLocator getInstance() {
		return instance;
	}

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
