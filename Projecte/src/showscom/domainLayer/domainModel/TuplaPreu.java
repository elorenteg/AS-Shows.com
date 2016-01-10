package showscom.domainLayer.domainModel;

import java.util.List;

public class TuplaPreu {
	private float preu;
	private List<Moneda> canvis;

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public List<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(List<Moneda> canvis) {
		this.canvis = canvis;
	}
}
