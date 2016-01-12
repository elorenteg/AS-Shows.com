package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDSeientNoExisteix;
import showscom.domainLayer.domainModel.Seient;

public interface ICtrlSeient {
	
	public Seient getSeient(String nomL, int fila, int columna) throws CDSeientNoExisteix;
	
	public void guardaSeient(Seient seient);

}
