package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.Representacio;

public interface ICtrlRepresentacio {

	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix;

	public void updateRepresentacio(Representacio representacio);
}
