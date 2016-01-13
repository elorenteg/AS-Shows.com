package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.domainLayer.domainModel.Espectacle;

/**
 * Interface del controlador de la classe Espectacle. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlEspectacle
 */
public interface ICtrlEspectacle {

	/**
	 * Selecciona un Espectacle identificat pel seu t�tol guardat a la BD
	 * @param titol t�tol de l'Espectacle
	 * @return Espectacle identificat per t�tol
	 * @throws CDEspectacleNoExisteix si no existeix l'Espectacle identificat
	 *         per t�tol
	 */
	public Espectacle getEspectacle(String titol) throws CDEspectacleNoExisteix;

	/**
	 * Selecciona tots els Espectacles guardats a la BD
	 * @return Llista amb tots els Espectacles
	 */
	public List<Espectacle> getAllEspectacle();

}
