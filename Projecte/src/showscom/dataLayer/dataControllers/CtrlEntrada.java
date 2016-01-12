package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDEntradaNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlEntrada;
import showscom.domainLayer.domainModel.Entrada;

public class CtrlEntrada implements ICtrlEntrada {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	public Entrada getEntrada(String id) throws CDEntradaNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Entrada ent = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Entrada WHERE Entrada.ident = :ident";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("ident", id)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				ent = (Entrada) session.get(Entrada.class, id);
			} else
				throw new CDEntradaNoExisteix();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return ent;

	}

	@SuppressWarnings("unchecked")
	public boolean existEntrada(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean exist = false;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Entrada WHERE Entrada.ident = :ident";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("ident", id)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				exist = false;
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
	public List<Entrada> getAllEntrada() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Entrada> listEnt = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Entrada";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String id = row.get("idEnt").toString();
				Entrada rep = (Entrada) session.get(Entrada.class, id);
				listEnt.add(rep);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listEnt;
	}
	
	public void guardaEntrada(Entrada entrada) {		
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			
			session.save(entrada);
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
