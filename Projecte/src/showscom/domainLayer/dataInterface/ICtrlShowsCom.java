package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.domainLayer.domainModel.ShowsCom;

/**
 * Interface del controlador de la classe ShowsCom. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlShowsCom
 */
public interface ICtrlShowsCom {

	/**
	 * Selecciona la inst�ncia de Showscom guardada a la BD
	 * @return ShowsCom inst�ncia de ShowsCom
	 * @throws CDShowsComNoExisteix si no existeix la inst�ncia de ShowsCom
	 */
	public ShowsCom getShowsCom() throws CDShowsComNoExisteix;

	/**
	 * Actualitza la inst�ncia de ShowsCom a la BD
	 * @param showsCom ShowsCom a actualizar
	 */
	public void updateShowsCom(ShowsCom showsCom);

}
