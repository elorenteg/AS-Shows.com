package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlCanvis;
import showscom.domainLayer.domainModel.Moneda;

public class CtrlCanvis implements ICtrlCanvis {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	public List<Moneda> getCanvis() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Moneda> listCanvis = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Canvis";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String canvi = row.get("canvi").toString();
				Moneda rep = (Moneda) session.get(Moneda.class, canvi);
				listCanvis.add(rep);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listCanvis;
	}
}
