package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.serviceLocator.ServiceLocator;

public class BankServiceAdapter implements IBankServiceAdapter{
	
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows, Date dAvui) {
		ServiceLocator serviceLocator = ServiceLocator.getInstance();
		// BankService bankService = serviceLocator.find("BankService");
		// BankService bankService = serviceLocator.getBankService();
		// return bankService.autoritza(dni, codiB, numCompte, preu, codiBShows, numCompteShows, dAvui);		
		return true;
	}

}
