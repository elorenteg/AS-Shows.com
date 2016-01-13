package showscom.domainLayer.domainModel;

/**
 * Classe auxiliar amb la fila i columna d'un Seient
 */
public class TuplaSeient {
	// Fila d'un seient en un local
	private int fila;
	// Columna d'un seient en un local
	private int columna;

	/**
	 * Constructora amb inicialitzacio d'atributs
	 * @param fila fila del seient al local
	 * @param columna columna dle seient al local
	 */
	public TuplaSeient(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	/**
	 * Consultora de la fila al local
	 * @return fila al local
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Consultora de la columna al local
	 * @return columna al local
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Comprova si dos seients son els mateixos mirant si la fila i columna son
	 * les mateixes entre elles
	 */
	@Override
	public boolean equals(Object seient) {
		if (seient != null && ((TuplaSeient) seient).getFila() == getFila()
				&& ((TuplaSeient) seient).getColumna() == getColumna())
			return true;
		else
			return false;
	}
}
