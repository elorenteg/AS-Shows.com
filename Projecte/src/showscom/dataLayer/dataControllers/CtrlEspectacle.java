package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.domainModel.Espectacle;

public class CtrlEspectacle implements ICtrlEspectacle {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	public Espectacle getEspectacle(String titol) throws CDEspectacleNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Espectacle esp = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Espectacle WHERE Espectacle.titol = :titol";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("titol", titol)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				esp = (Espectacle) session.get(Espectacle.class, titol);
			} else
				throw new CDEspectacleNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return esp;
	}

	@SuppressWarnings("unchecked")
	public boolean existEspectacle(String titol) throws CDEspectacleNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean exist = false;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Espectacle WHERE Espectacle.titol = :titol";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("titol", titol)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				exist = true;
			} else
				throw new CDEspectacleNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return exist;
	}

	@SuppressWarnings("unchecked")
	public List<Espectacle> getAllEspectacles() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Espectacle> listEsp = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Espectacle";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String titol = row.get("titol").toString();
				Espectacle esp = (Espectacle) session.get(Espectacle.class, titol);
				listEsp.add(esp);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return listEsp;
	}
}
