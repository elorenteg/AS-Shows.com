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

public class CtrlShowsCom implements ICtrlShowsCom {

	private final static SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

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
				System.out.println(id);
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
}
