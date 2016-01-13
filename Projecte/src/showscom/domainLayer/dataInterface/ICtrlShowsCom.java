package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.domainLayer.domainModel.ShowsCom;

/**
 * Interface del controlador de la classe ShowsCom. Ens permet definir que
 * metodes ha d'implementar qualsevol CtrlShowsCom
 */
public interface ICtrlShowsCom {

	/**
	 * Selecciona la instància de Showscom guardada a la BD
	 * @return ShowsCom instància de ShowsCom
	 * @throws CDShowsComNoExisteix si no existeix la instància de ShowsCom
	 */
	public ShowsCom getShowsCom() throws CDShowsComNoExisteix;

	/**
	 * Actualitza la instància de ShowsCom a la BD
	 * @param showsCom ShowsCom a actualizar
	 */
	public void updateShowsCom(ShowsCom showsCom);

}
