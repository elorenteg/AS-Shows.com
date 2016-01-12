package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.domainLayer.domainModel.ShowsCom;

public interface ICtrlShowsCom {

	public ShowsCom getShowsCom() throws CDShowsComNoExisteix;

	public void actualitzaShowsCom(ShowsCom showsCom);

}
