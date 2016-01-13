package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.SeientEnRepresentacio;

/**
 * Interface del controlador de la classe SeientEnRepresentacio. Ens permet
 * definir que metodes ha d'implementar qualsevol CtrlSeientEnRepresentacio
 *
 */
public interface ICtrlSeientEnRepresentacio {

	/**
	 * Selecciona un SeientEnRepresentacio identificat pel seu Seient (local +
	 * fila + columna) i la seva Representacio (sessio + local) guardat a la BD
	 * @param fila fila del Seient
	 * @param columna columna del Seient
	 * @param nomL nom del Local
	 * @param sessio sessio de la Representacio
	 * @return SeientEnRepresentacio identificat per fila, columna, nomL i
	 *         sessio
	 * @throws CDSeientEnRepresentacioNoExisteix si no existeix el
	 *         SeientEnRepresentacio identificat per fila, columna, nomL i
	 *         sessio
	 */
	public SeientEnRepresentacio getSeientEnRepresentacio(int fila, int columna, String nomL, String sessio)
			throws CDSeientEnRepresentacioNoExisteix;

	/**
	 * Inserta un SeientEnRepresentacio a la BD
	 * @param seientEnRepresentacio SeientEnRepresentació a insertar
	 */
	public void insertSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio);

	/**
	 * Actualitza un SeientEnRepresentacio a la BD
	 * @param seientEnRepresentacio SeientEnRepresentació a actualitzar
	 */
	public void updateSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio);
}
