package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.domainModel.Local;

/**
 * Controlador de la classe Local. Gestiona els accessos amb la BD
 */
public class CtrlLocal implements ICtrlLocal {

	//Instancia de la SessionFactory per connectar-se amb la BD
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona un Local identificat pel seu nom guardat a la BD
	 * @param nomLocal nom del Local
	 * @return Local identificat per nomLocal
	 * @throws CDLocalNoExisteix si no existeix el Local identificat per
	 *         nomLocal
	 */
	public Local getLocal(String nomLocal) throws CDLocalNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Local loc = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Local WHERE Local.nom = :nom";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nom", nomLocal)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				loc = (Local) session.get(Local.class, nomLocal);
			} else
				throw new CDLocalNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return loc;
	}

	/**
	 * Inserta un Local a la BD
	 * @param local Local a insertar
	 */
	public void insertLocal(Local local) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(local);
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
