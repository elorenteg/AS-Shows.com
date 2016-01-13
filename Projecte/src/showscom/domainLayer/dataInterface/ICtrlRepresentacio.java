package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.Representacio;

/**
 * Interface del controlador de la classe Representacio. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlRepresentacio
 *
 */
public interface ICtrlRepresentacio {

	/**
	 * Selecciona una Representació identificada per una sessió i un local
	 * guardada a la BD
	 * @param nomL nom de local de la Representació
	 * @param sessio sessio de la Representació
	 * @return Representació identificada per nomL i sessio
	 * @throws CDRepresentacioNoExisteix si no existeix la Representació
	 *         identificada per nomL i sessio
	 */
	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix;

	/**
	 * Actualitza una Representació a la BD
	 * @param representacio Representació a actualitzar
	 */
	public void updateRepresentacio(Representacio representacio);
}
