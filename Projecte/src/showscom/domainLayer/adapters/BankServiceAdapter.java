package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.BankService;

public class BankServiceAdapter implements IBankServiceAdapter {

	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible {
		ServiceLocator serviceLocator = ServiceLocator.getInstance(); // Innecesario
																		// si
																		// getBankService
																		// es
																		// static
		// BankService bankService = serviceLocator.find("BankService");
		BankService bankService = serviceLocator.getBankService(); // sobre la
																	// clase
																	// ServiceLocator
																	// y no
																	// sobre la
																	// variable
																	// (http://stackoverflow.com/a/25494615)
		return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);
	}

}
