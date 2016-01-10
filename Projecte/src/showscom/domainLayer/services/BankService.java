package showscom.domainLayer.services;

import java.util.Date;

public class BankService implements Service {
	private static final String name = "BankService";

	public String getName() {
		return name;
	}

	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows,
			Date dAvui) {
		return true;
	}

}
