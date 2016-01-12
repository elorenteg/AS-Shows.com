package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDLocalNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlLocal;
import showscom.domainLayer.domainModel.Local;

public class CtrlLocal implements ICtrlLocal {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public boolean existLocal(String nomLocal) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean exist = false;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Local WHERE Local.nom = :nom";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nom", nomLocal)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				exist = true;
			}
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Local> getAllLocal() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Local> listLoc = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Local";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String nomLocal = row.get("nom").toString();
				Local loc = (Local) session.get(Local.class, nomLocal);
				listLoc.add(loc);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listLoc;
	}

	public void guardaLocal(Local local) {
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
