package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;
import showscom.domainLayer.serviceLocator.ServiceLocator;
import showscom.domainLayer.services.BankService;
import showscom.domainLayer.services.CurrencyConvertor;

public class BankServiceAdapter implements IBankServiceAdapter {

	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) throws DOServeiNoDisponible {

		ServiceLocator servLoc = ServiceLocator.getInstance();
		BankService bankService = (BankService) servLoc.find("BankService");
		return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);
		
		/*
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
		*/
	}

}
