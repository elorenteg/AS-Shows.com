package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.domainModel.Representacio;

public class CercaRepresentacions {

	private final static SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	@SuppressWarnings("unchecked")
	private static Representacio cercaRepresentacio(String sessio, String local, String titolE) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Representacio representacio = null;

		try {
			tx = session.beginTransaction();
			List<Representacio> listRepr = session.createCriteria(Representacio.class)
					.add(Restrictions.eq("representacioPK.nomLocal", local))
					.add(Restrictions.eq("representacioPK.sessio", sessio))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listRepr.size() == 0) {
				System.out.println("No hi ha cap representacio amb aquesta sessio, local i espectacle");
			} else {
				representacio = listRepr.get(0);
				System.out.println(representacio.toString());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return representacio;
	}

	public static void main(String args[]) throws ParseException {
		// para comprobar que si se hace update de sessio en Representació, se
		// actualiza la representacioPK.sessio y la asociacion sessio
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("26/01/2016");
		Representacio repr = cercaRepresentacio("MATI", "Gran Teatre del Liceu", "Cisne negro");
		Representacio repr2 = cercaRepresentacio("NIT", "Gran Teatre del Liceu", "Cisne negro");
	}
}
