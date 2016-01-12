package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDSeientEnRepresentacioNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlSeientEnRepresentacio;
import showscom.domainLayer.domainModel.SeientEnRepresentacio;
import showscom.domainLayer.domainModel.SeientEnRepresentacioPK;

public class CtrlSeientEnRepresentacio implements ICtrlSeientEnRepresentacio {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	public SeientEnRepresentacio getSeientEnRepresentacio(int fila, int columna, String nomL, String sessio)
			throws CDSeientEnRepresentacioNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		SeientEnRepresentacio seient = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM SeientEnRepresentacio WHERE SeientEnRepresentacio.noml = :nomL AND SeientEnRepresentacio.sessio = :sessio AND SeientEnRepresentacio.fila = :fila AND SeientEnRepresentacio.columna = :columna";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("sessio", sessio)
					.setParameter("fila", fila).setParameter("columna", columna)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				seient = (SeientEnRepresentacio) session.get(SeientEnRepresentacio.class,
						new SeientEnRepresentacioPK(fila, columna, nomL, sessio));
			} else
				throw new CDSeientEnRepresentacioNoExisteix();
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

	@SuppressWarnings("unchecked")
	public boolean existSeientEnRepresentacio(int fila, int columna, String nomL, String sessio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean exist = false;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM SeientEnRepresentacio WHERE SeientEnRepresentacio.noml = :nomL AND SeientEnRepresentacio.sessio = :sessio AND SeientEnRepresentacio.fila = :fila AND SeientEnRepresentacio.columna = :columna";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("sessio", sessio)
					.setParameter("fila", fila).setParameter("columna", columna)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1)
				exist = true;
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
	public List<SeientEnRepresentacio> getAllSeientEnRepresentacio() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<SeientEnRepresentacio> listSeients = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM SeientEnRepresentacio";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				int fila = (int) row.get("fila");
				int columna = (int) row.get("columna");
				String nomL = row.get("noml").toString();
				String sessio = row.get("sessio").toString();
				SeientEnRepresentacio seient = (SeientEnRepresentacio) session.get(SeientEnRepresentacio.class,
						new SeientEnRepresentacioPK(fila, columna, nomL, sessio));
				listSeients.add(seient);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listSeients;
	}

	public void guardaSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(seientEnRepresentacio);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualitzaSeientEnRepresentacio(SeientEnRepresentacio seientEnRepresentacio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.update(seientEnRepresentacio);
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
