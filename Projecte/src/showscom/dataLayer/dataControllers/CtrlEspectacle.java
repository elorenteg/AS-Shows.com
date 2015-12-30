package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
			List<Espectacle> listEsp = session.createCriteria(Espectacle.class).add(Restrictions.eq("titol", titol))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listEsp.size() == 1) {
				esp = listEsp.get(1);
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
			List<Espectacle> listEsp = session.createCriteria(Espectacle.class).add(Restrictions.eq("titol", titol))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listEsp.size() == 1) {
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
		List<Espectacle> llista = null;

		try {
			tx = session.beginTransaction();
			List<Espectacle> listEsp = session.createCriteria(Espectacle.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			llista = listEsp;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return llista;
	}
}
