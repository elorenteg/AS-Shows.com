package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.Representacio;

/**
 * Interface del controlador de la classe Representacio. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlRepresentacio
 */
public interface ICtrlRepresentacio {

	/**
	 * Selecciona una Representacio identificada per una sessio i un local
	 * guardada a la BD
	 * @param nomL nom de local de la Representacio
	 * @param sessio sessio de la Representacio
	 * @return Representacio identificada per nomL i sessio
	 * @throws CDRepresentacioNoExisteix si no existeix la Representacio
	 *         identificada per nomL i sessio
	 */
	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix;

	/**
	 * Actualitza una Representacio a la BD
	 * @param representacio Representacio a actualitzar
	 */
	public void updateRepresentacio(Representacio representacio);
}
