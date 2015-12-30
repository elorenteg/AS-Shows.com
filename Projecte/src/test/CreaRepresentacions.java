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
import org.postgresql.jdbc2.EscapedFunctions;

import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.domainModel.Espectacle;
import showscom.domainLayer.domainModel.Local;
import showscom.domainLayer.domainModel.Representacio;
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
			} else {
				System.out.println("Sessio ja esta a la BD");
				sessio = listSes.get(0);
			}
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

	private static Espectacle creaEspectacle(String titol, int participants) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Espectacle espectacle = null;

		try {
			tx = session.beginTransaction();
			List<Espectacle> listEsp = session.createCriteria(Espectacle.class).add(Restrictions.eq("titol", titol))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listEsp.size() == 0) {
				espectacle = new Espectacle(titol, participants);
				session.save(espectacle);
			} else {
				System.out.println("Espectacle ja esta a la BD");
				espectacle = listEsp.get(0);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return espectacle;
	}

	private static Local creaLocal(String nom, String adreca) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Local local = null;

		try {
			tx = session.beginTransaction();
			List<Local> listLoc = session.createCriteria(Local.class).add(Restrictions.eq("nom", nom))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listLoc.size() == 0) {
				local = new Local(nom, adreca);
				session.save(local);
			} else {
				System.out.println("Local ja esta a la BD");
				local = listLoc.get(0);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return local;
	}

	private static Representacio creaRepresentacio(Sessio sessio, Local local, float preu, Date data,
			int nombreSeientsLliures) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Representacio representacio = null;

		try {
			tx = session.beginTransaction();
			List<Representacio> listRepr = session.createCriteria(Representacio.class)
					.add(Restrictions.eq("representacioPK.nomLocal", local.getNom()))
					.add(Restrictions.eq("representacioPK.sessio", sessio.getSessio().name()))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			if (listRepr.size() == 0) {
				representacio = new Representacio(sessio, local, preu, data, nombreSeientsLliures);
				session.save(representacio);
			} else {
				System.out.println("Representacio ja esta a la BD");
				representacio = listRepr.get(0);
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
		Sessio ses = creaSessio(TipusSessio.MATI);
		if (ses != null)
			System.out.println(ses.getSessio());

		Espectacle esp = creaEspectacle("Lago de los cisnes", 10);
		if (esp != null)
			System.out.println(esp.getTitol() + " " + esp.getParticipants());

		Local loc = creaLocal("disgor", "travessera");
		if (loc != null)
			System.out.println(loc.getNom() + " " + loc.getAdreca());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("21/12/2012");
		Representacio repr = creaRepresentacio(ses, loc, 9.80f, d, 100);
		if (repr != null)
			System.out.println(repr.getPreu() + " " + repr.getData() + " " + repr.getNombreSeientsLliures());
	}
}
