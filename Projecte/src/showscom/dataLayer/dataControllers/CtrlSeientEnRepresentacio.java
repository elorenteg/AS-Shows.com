package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlSeientEnRepresentacio;
import showscom.domainLayer.domainModel.SeientEnRepresentacio;
import showscom.domainLayer.domainModel.SeientEnRepresentacioPK;

/**
 * Controlador de la classe SeientEnRepresentacio. Gestiona els accessos amb la
 * BD
 */
public class CtrlSeientEnRepresentacio implements ICtrlSeientEnRepresentacio {

	// Instancia de la SessionFactory per connectar-se amb la BD
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona un SeientEnRepresentacio identificat pel seu Seient (local +
	 * fila + columna) i la seva Representacio (sessio + local) guardat a la BD
	 * @param fila fila del Seient
	 * @param columna columna del Seient
	 * @param nomL nom del Local
	 * @param sessio sessio de la Representacio
	 * @return SeientEnRepresentacio identificat per fila, columna, nomL i
	 *         sessio
	 * @throws CDSeientEnRepresentacioNoExisteix si no existeix el
	 *         SeientEnRepresentacio identificat per fila, columna, nomL i
	 *         sessio
	 */
	public SeientEnRepresentacio getSeientEnRepresentacio(int fila, int columna, String nomL, String sessio)
			throws CDSeientEnRepresentacioNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		SeientEnRepresentacio seient = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM SeientEnRepresentacio WHERE SeientEnRepresentacio.noml = :nomL AND SeientEnRepresentacio.sessio = :sessio AND SeientEnRepresentacio.fila = :fila AND SeientEnRepresentacio.columna = :columna";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("sessio", sessio)
					.setParameter("fila", fila).setParameter("columna", columna)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				seient = (SeientEnRepresentacio) session.get(SeientEnRepresentacio.class,
						new SeientEnRepresentacioPK(fila, columna, nomL, sessio));
			} else
				throw new CDSeientEnRepresentacioNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return seient;

	}

	/**
	 * Inserta un SeientEnRepresentacio a la BD
	 * @param seientEnRepresentacio SeientEnRepresentacio a insertar
	 */
	public void insertSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(seientEnRepresentacio);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Actualitza un SeientEnRepresentacio a la BD
	 * @param seientEnRepresentacio SeientEnRepresentacio a actualitzar
	 */
	public void updateSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.update(seientEnRepresentacio);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
