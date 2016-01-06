package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDRepresentacioNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlRepresentacio;
import showscom.domainLayer.domainModel.Representacio;
import showscom.domainLayer.domainModel.RepresentacioPK;

public class CtrlRepresentacio implements ICtrlRepresentacio {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	public Representacio getRepresentacio(String nomL, String sessio) throws CDRepresentacioNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Representacio rep = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Representacio WHERE Representacio.noml = :nomL AND Representacio.sessio = :sessio";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("sessio", sessio)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				rep = (Representacio) session.get(Representacio.class, new RepresentacioPK(sessio, nomL));
			} else
				throw new CDRepresentacioNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rep;

	}

	@SuppressWarnings("unchecked")
	public boolean existRepresentacio(String nomL, String sessio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean exist = false;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Representacio WHERE Representacio.noml = :nomL AND Representacio.sessio = :sessio";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("sessio", sessio)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1)
				exist = true;
			else
				exist = false;
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
	public List<Representacio> getAllRepresentacio() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Representacio> listRep = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Representacio";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String nomL = row.get("noml").toString();
				String sessio = row.get("sessio").toString();
				Representacio rep = (Representacio) session.get(Representacio.class, new RepresentacioPK(sessio, nomL));
				listRep.add(rep);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listRep;
	}

}
