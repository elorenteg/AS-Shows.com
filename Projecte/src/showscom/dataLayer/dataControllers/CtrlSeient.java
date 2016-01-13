package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDSeientNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlSeient;
import showscom.domainLayer.domainModel.Seient;
import showscom.domainLayer.domainModel.SeientPK;

/**
 * Controlador de la classe Seient. Gestiona els accessos amb la BD
 */
public class CtrlSeient implements ICtrlSeient {

	/**
	 * Instancia de la SessionFactory per connectar-se amb la BD
	 */
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona un Seient identificat per la seva fila i columna en un local
	 * guardat a la BD
	 * @param nomL nom del local
	 * @param fila fila al local
	 * @param columna al local
	 * @return Seient identificat per nomL, fila i columna
	 * @throws CDSeientNoExisteix si no existeix el Seient identificat per nomL,
	 *         fila i columna
	 */
	public Seient getSeient(String nomL, int fila, int columna) throws CDSeientNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Seient seient = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Seient WHERE Seient.noml = :nomL AND Seient.fila = :fila AND Seient.columna = :columna";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("fila", fila)
					.setParameter("columna", columna).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				seient = (Seient) session.get(Seient.class, new SeientPK(fila, columna, nomL));
			} else
				throw new CDSeientNoExisteix();
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
	 * Inserta un Seient a la BD
	 * @param seient Seient a insertar
	 */
	public void insertSeient(Seient seient) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(seient);
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
