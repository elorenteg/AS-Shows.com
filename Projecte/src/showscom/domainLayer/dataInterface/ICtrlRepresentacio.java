package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.domainLayer.domainModel.Representacio;

public interface ICtrlRepresentacio {

	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix;

	public boolean existRepresentacio(String titol) throws CDRepresentacioNoExisteix;

	public List<Representacio> getAllRepresentacio();

}
