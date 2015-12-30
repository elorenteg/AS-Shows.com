package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.domainModel.Espectacle;
import showscom.domainLayer.domainModel.Sessio;
import showscom.domainLayer.domainModel.TipusSessio;

public class CreaRepresentacions {

	private final static SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	private static Sessio creaSessio(TipusSessio tipusSessio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Sessio sessio = null;

		try {
			tx = session.beginTransaction();
			List<Sessio> listSes = session.createCriteria(Sessio.class).add(Restrictions.eq("sessio", tipusSessio))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listSes.size() == 0) {
				sessio = new Sessio(tipusSessio);
				session.save(sessio);
			} else
				System.out.println("Sessio ja esta a la BD");
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return sessio;
	}

	public static void main(String args[]) {
		Sessio ses = creaSessio(TipusSessio.TARDA);
		if (ses != null)
			System.out.println(ses.getSessio());
	}
}
