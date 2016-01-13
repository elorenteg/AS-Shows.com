package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.SeientEnRepresentacio;

public interface ICtrlSeientEnRepresentacio {

	public SeientEnRepresentacio getSeientEnRepresentacio(int fila, int columna, String nomL, String sessio)
			throws CDSeientEnRepresentacioNoExisteix;

	public void insertSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio);

	public void updateSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio);
}
