package showscom.domainLayer.dataInterface;

import java.util.List;

import showscom.dataLayer.exceptions.CDEntradaNoExisteix;
import showscom.domainLayer.domainModel.Entrada;

public interface ICtrlEntrada {

	public Entrada getEntrada(String id) throws CDEntradaNoExisteix;

	public boolean existEntrada(String id);

	public List<Entrada> getAllEntrada();
}
