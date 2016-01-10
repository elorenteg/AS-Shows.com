package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.SeientEnRepresentacio;

public interface ICtrlSeientEnRepresentacio {

	public SeientEnRepresentacio getSeientEnRepresentacio(int fila, int columna, String nomL, String sessio, String titolE)
			throws CDSeientEnRepresentacioNoExisteix;

	public boolean existSeientEnRepresentacio(int fila, int columna, String nomL, String sessio, String titolE);

	public List<SeientEnRepresentacio> getAllSeientEnRepresentacio();

}
