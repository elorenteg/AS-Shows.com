package showscom.domainLayer.adapters;

import java.util.Date;

import showscom.domainLayer.exceptions.DOServeiNoDisponible;

public interface IBankServiceAdapter {
	
	public boolean autoritza(String dni, int codiB, String numCompte, float preu, int codiBShows, String numCompteShows, Date dAvui) throws DOServeiNoDisponible;
	
}
