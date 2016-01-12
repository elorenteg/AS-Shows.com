package showscom.domainLayer.dataInterface;

import showscom.dataLayer.exceptions.CDEntradaNoExisteix;
import showscom.domainLayer.domainModel.Entrada;

public interface ICtrlEntrada {

	public Entrada getEntrada(String id) throws CDEntradaNoExisteix;

	public void insertEntrada(Entrada entrada);
}
