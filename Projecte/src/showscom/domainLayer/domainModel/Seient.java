package showscom.domainLayer.domainModel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seient")
public class Seient {

	@Id
	@Embedded
	private SeientPK seientPK;
	@ManyToOne
	@JoinColumn(name = "local", referencedColumnName = "nom", insertable = false, updatable = false)
	private Local local;
	
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
