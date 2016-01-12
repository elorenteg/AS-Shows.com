package showscom.domainLayer.serviceLocator;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.services.BankService;
import showscom.domainLayer.services.CurrencyConvertor;
import showscom.domainLayer.services.Service;

public class ServiceLocator {
	private static ServiceLocator instance = new ServiceLocator();
	// private static List<Service> services;
	private static BankService bank;
	private static CurrencyConvertor conv;

	private ServiceLocator() {
		/*
		 * no creo los servicios porque entiendo que es mejor crearlos cuando se
		 * necesiten en el momento que se haya pedido un servicio siempre se
		 * devolver� la misma instancia esto s�lo se aplica si utilizamos los
		 * get y no el find con el find entiendo que necesitariamos una cache
		 */

	}

	public static ServiceLocator getInstance() {
		return instance;
	}

	public static Service find(String serviceName) {
		if (serviceName.equals("BankService")) {
			if (bank == null)
				bank = new BankService(); // throw new DoServeiNoDisponible();
			return (Service) bank;
		} else if (serviceName.equals("CurrencyConvertor")) {
			if (conv == null)
				conv = new CurrencyConvertor(); // throw new
												// DoServeiNoDisponible();
			return (Service) conv;
		}

		return null;
	}

	/*
	 * public static Service find(String serviceName) { for (Service service :
	 * services) { if(service.getName().equalsIgnoreCase(serviceName)){ return
	 * service; } } return null; }
	 */

	public static BankService getBankService() throws DOServeiNoDisponible {
		if (bank == null)
			bank = new BankService(); // throw new DoServeiNoDisponible();
		return bank;
	}

	/*
	 * public static CurrencyConvertor CurrencyConvertor() { if
	 * (CurrencyConvertor == null) CurrencyConvertor = new CurrencyConvertor();
	 * return CurrencyConvertor; }
	 */

}
