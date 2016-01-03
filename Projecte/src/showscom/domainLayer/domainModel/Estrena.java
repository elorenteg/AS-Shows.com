package showscom.domainLayer.domainModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Estrena")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "nomLocal"), @PrimaryKeyJoinColumn(name = "tipusSessio"),
		@PrimaryKeyJoinColumn(name = "titolE") })
public class Estrena extends Representacio {
	@Column(name = "recarrec")
	private int recarrec;

	public Estrena() {
	}

	public Estrena(Sessio sessio, Local local, String titolE, float preu, Date data, int nombreSeientsLliures,
			int recarrec) {
		super(sessio, local, titolE, preu, data, nombreSeientsLliures);
		this.recarrec = recarrec;
	}

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}

	public boolean esEstrena() {
		return true;
	}
}
