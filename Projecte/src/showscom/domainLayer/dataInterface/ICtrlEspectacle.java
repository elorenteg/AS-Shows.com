package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.domainLayer.domainModel.Espectacle;

public interface ICtrlEspectacle {

	public Espectacle getEspectacle(String titol) throws CDEspectacleNoExisteix;

	public boolean existEspectacle(String titol) throws CDEspectacleNoExisteix;

	public List<Espectacle> getAllEspectacles();

}
