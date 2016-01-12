package showscom.domainLayer.domainModel;

import java.util.List;

public class TuplaPreu {
	private float preu;
	private List<String> canvis;

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public List<String> getCanvis() {
		return canvis;
	}

	public void setCanvis(List<String> canvis) {
		this.canvis = canvis;
	}
}
