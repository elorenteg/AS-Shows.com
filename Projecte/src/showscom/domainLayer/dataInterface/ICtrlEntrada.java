package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDEntradaNoExisteix;
import showscom.domainLayer.domainModel.Entrada;

/**
 * Interface del controlador de la classe Entrada. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlEntrada
 *
 */
public interface ICtrlEntrada {

	/**
	 * Selecciona una Entrada identificada pel seu identificador guardada a la
	 * BD
	 * @param id identificador de l'Entrada
	 * @return Entrada identificada per id
	 * @throws CDEntradaNoExisteix si no existeix l'Entrada identificada per id
	 */
	public Entrada getEntrada(String id) throws CDEntradaNoExisteix;

	/**
	 * Inserta una Entrada a la BD
	 * @param entrada Entrada a insertar
	 */
	public void insertEntrada(Entrada entrada);
}
