package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.domainLayer.domainModel.Local;

public interface ICtrlLocal {

	public Local getLocal(String nomL) throws CDLocalNoExisteix;

	public boolean existLocal(String nomL) throws CDLocalNoExisteix;

	public List<Local> getAllLocal();
	
	public void guardaLocal(Local local);

}
