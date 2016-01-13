package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDSeientNoExisteix;
import showscom.domainLayer.domainModel.Seient;

/**
 * Interface del controlador de la classe Seient. Ens permet definir que metodes
 * ha d'implementar qualsevol CtrlSeient
 */
public interface ICtrlSeient {

	/**
	 * Selecciona un Seient identificat per la seva fila i columna en un local
	 * guardat a la BD
	 * @param nomL nom del local
	 * @param fila fila al local
	 * @param columna al local
	 * @return Seient identificat per nomL, fila i columna
	 * @throws CDSeientNoExisteix si no existeix el Seient identificat per nomL,
	 *         fila i columna
	 */
	public Seient getSeient(String nomL, int fila, int columna) throws CDSeientNoExisteix;

	/**
	 * Inserta un Seient a la BD
	 * @param seient Seient a insertar
	 */
	public void insertSeient(Seient seient);

}
