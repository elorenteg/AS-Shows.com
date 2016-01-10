package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RepresentacioPK implements Serializable {
	@Column(name = "sessio")
	String sessio;
	@Column(name = "nomL")
	String nomLocal;

	public RepresentacioPK() {
	}

	public RepresentacioPK(String sessio, String nomLocal) {
		super();
		this.sessio = sessio;
		this.nomLocal = nomLocal;
	}

	public String getSessio() {
		return sessio;
	}

	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

}
