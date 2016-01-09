package showscom.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeientEnRepresentacioPK implements Serializable {
	
	private SeientPK seientPK;
	@Column(name = "sessio")
	private String sessio;
	
	public SeientEnRepresentacioPK() {
		
	}

	public SeientEnRepresentacioPK(int fila, int columna, String nomLocal, String sessio) {
		super();
		this.seientPK = new SeientPK(fila, columna, nomLocal);
		this.sessio = sessio;
	}
	
	public SeientPK getSeientPK() {
		return seientPK;
	}
	
	public void setSeientPK(SeientPK seientPK) {
		this.seientPK = seientPK;		
	}

	public int getFila() {
		return seientPK.getFila();
	}

	public void setFila(int fila) {
		seientPK.setFila(fila);
	}

	public int getColumna() {
		return seientPK.getColumna();
	}

	public void setColumna(int columna) {
		seientPK.setColumna(columna);
	}
	
	public String getNomLocal() {
		return seientPK.getNomLocal();
	}

	public void setNomLocal(String nomLocal) {
		seientPK.setNomLocal(nomLocal);
	}
	
	public String getSessio() {
		return sessio;
	}

	public void setSessio(String sessio) {
		this.sessio = sessio;
	}

}
