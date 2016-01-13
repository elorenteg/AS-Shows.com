package showscom.domainLayer.domainModel;

import java.util.List;

/**
 * Classe auxiliar amb preu en la divisa principal i divises alternatives
 */
public class TuplaPreu {
	// Preu en la divisa principal del sistema
	private float preu;
	// Divises alternatives de pagament
	private List<String> canvis;

	/**
	 * Consultora del preu
	 * @return preu a la divisa principal del sistema de Shows.com
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Modificadora del preu
	 * @param preu preu a la divisa principal del sistema de Shows.com
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

	/**
	 * Consultora de les divises alternatives
	 * @return llista de divises alternatives de pagament
	 */
	public List<String> getCanvis() {
		return canvis;
	}

	/**
	 * Modificadora de les divises alternatives
	 * @param canvis llista de divises alternatives de pagament
	 */
	public void setCanvis(List<String> canvis) {
		this.canvis = canvis;
	}
}
