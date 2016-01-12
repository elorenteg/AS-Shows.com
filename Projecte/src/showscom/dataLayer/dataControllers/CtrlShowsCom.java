package showscom.dataLayer.dataControllers;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDShowsComNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlShowsCom;
import showscom.domainLayer.domainModel.ShowsCom;

/**
 * Controlador de la classe ShowsCom. Gestiona els accessos amb la BD
 */
public class CtrlShowsCom implements ICtrlShowsCom {

	/**
	 * Instancia de la SessionFactory per connectar-se amb la BD
	 */
	private final static SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona la instància de Showscom guardada a la BD
	 * @return ShowsCom instància de ShowsCom
	 * @throws CDShowsComNoExisteix si no existeix la instància de ShowsCom
	 */
	public ShowsCom getShowsCom() throws CDShowsComNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		ShowsCom showsCom = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM ShowsCom";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			if (listObj.size() == 1) {
				Map row = (Map) listObj.get(0);
				int id = (int) row.get("id");
				showsCom = (ShowsCom) session.get(ShowsCom.class, id);
			} else
				throw new CDShowsComNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return showsCom;
	}

	/**
	 * Actualitza la instància de ShowsCom a la BD
	 * @param showsCom ShowsCom a actualizar
	 */
	public void updateShowsCom(ShowsCom showsCom) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.update(showsCom);
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
