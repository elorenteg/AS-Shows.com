package showscom.domainLayer.domainModel;

public class TuplaSeient {
	private int fila;
	private int columna;

	public TuplaSeient() {
	}

	public TuplaSeient(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	@Override
	public boolean equals(Object seient) {
		if (seient != null && ((TuplaSeient) seient).getFila() == getFila()
				&& ((TuplaSeient) seient).getColumna() == getColumna())
			return true;
		else
			return false;
	}
}
