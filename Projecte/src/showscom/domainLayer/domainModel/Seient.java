package showscom.domainLayer.domainModel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Seient")
@Check(constraints = "fila > 0 AND columna > 0")
public class Seient {
	@Id
	@Embedded
	private SeientPK seientPK;
	@ManyToOne
	@JoinColumn(name = "nomL", referencedColumnName = "nom", insertable = false, updatable = false)
	private Local local;

	public Seient() {
	}
	
	public Seient(int fila, int columna, Local local) {
		seientPK = new SeientPK(fila, columna, local.getNom());
		this.local = local;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
