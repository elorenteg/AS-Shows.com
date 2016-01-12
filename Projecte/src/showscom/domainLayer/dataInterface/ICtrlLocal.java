package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.domainLayer.domainModel.Local;

public interface ICtrlLocal {

	public Local getLocal(String nomL) throws CDLocalNoExisteix;

	public void insertLocal(Local local);

}
