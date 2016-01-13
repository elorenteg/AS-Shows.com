package showscom.domainLayer.domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Representaci� d'un Espectacle
 */
@Entity
@Table(name = "Espectacle")
@Check(constraints = "participants > 0")
public class Espectacle implements Serializable {
	// T�tol de l'espectacle (identificador)
	@Id
	@Column(name = "titol")
	private String titol;
	// Participants a l'espectacle
	@Column(name = "participants")
	private int participants;
	// Representacions de l'espectacle
	@Column(name = "representacions")
	@OneToMany(targetEntity = Representacio.class, mappedBy = "titolE", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Representacio> representacions;

	/**
	 * Constructor per defecte
	 */
	public Espectacle() {
	}

	/**
	 * Constructor amb inicialitzaci� d'atributs
	 * @param titol t�tol de l'espectacle
	 * @param participants n�m. de participants de l'espectacle
	 */
	public Espectacle(String titol, int participants) {
		super();
		this.titol = titol;
		this.participants = participants;
	}

	/**
	 * Consultora del t�tol de l'espectacle
	 * @return t�tol de l'espectacle
	 */
	public String getTitol() {
		return titol;
	}

	/**
	 * Obt� la informaci� de les representacions de l'espectacle en una data
	 * @param data data de les representacions
	 * @return llista amb la informaci� de les representacions
	 */
	public List<TuplaRepr> obteInformacio(Date data) {
		List<TuplaRepr> rs = new ArrayList<TuplaRepr>();

		for (Representacio r : representacions) {
			Date dataR = r.getData();
			if (data.equals(dataR)) {
				TuplaRepr info = r.obteInformacio();
				rs.add(info);
			}
		}

		return rs;
	}
}
