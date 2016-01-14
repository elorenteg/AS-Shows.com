package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.domainLayer.domainModel.Local;

/**
 * Interface del controlador de la classe Local. Ens permet definir que metodes
 * ha d'implementar qualsevol CtrlLocal
 */
public interface ICtrlLocal {

	/**
	 * Selecciona un Local identificat pel seu nom guardat a la BD
	 * @param nomL nom del Local
	 * @return Local identificat per nomLocal
	 * @throws CDLocalNoExisteix si no existeix el Local identificat per
	 *         nomLocal
	 */
	public Local getLocal(String nomL) throws CDLocalNoExisteix;

	/**
	 * Inserta un Local a la BD
	 * @param local Local a insertar
	 */
	public void insertLocal(Local local);

}
