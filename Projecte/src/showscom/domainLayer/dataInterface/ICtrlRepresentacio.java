package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.Representacio;

/**
 * Interface del controlador de la classe Representacio. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlRepresentacio
 */
public interface ICtrlRepresentacio {

	/**
	 * Selecciona una Representaci� identificada per una sessi� i un local
	 * guardada a la BD
	 * @param nomL nom de local de la Representaci�
	 * @param sessio sessio de la Representaci�
	 * @return Representaci� identificada per nomL i sessio
	 * @throws CDRepresentacioNoExisteix si no existeix la Representaci�
	 *         identificada per nomL i sessio
	 */
	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix;

	/**
	 * Actualitza una Representaci� a la BD
	 * @param representacio Representaci� a actualitzar
	 */
	public void updateRepresentacio(Representacio representacio);
}
