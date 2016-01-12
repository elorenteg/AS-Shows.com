package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDSeientNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlSeient;
import showscom.domainLayer.domainModel.Seient;
import showscom.domainLayer.domainModel.SeientPK;

public class CtrlSeient implements ICtrlSeient {

	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	public Seient getSeient(String nomL, int fila, int columna) throws CDSeientNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Seient seient = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Seient WHERE Seient.noml = :nomL AND Seient.fila = :fila AND Seient.columna = :columna";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("nomL", nomL).setParameter("fila", fila)
					.setParameter("columna", columna).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				seient = (Seient) session.get(Seient.class, new SeientPK(fila, columna, nomL));
			} else
				throw new CDSeientNoExisteix();
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

	public void guardaSeient(Seient seient) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(seient);
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
