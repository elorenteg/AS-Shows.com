package showscom.dataLayer.dataControllers;

import java.util.List;

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

/**
 * Controlador de la classe Representació. Gestiona els accessos amb la BD
 */
public class CtrlRepresentacio implements ICtrlRepresentacio {

	//Instancia de la SessionFactory per connectar-se amb la BD
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona una Representació identificada per una sessió i un local
	 * guardada a la BD
	 * @param nomL nom de local de la Representació
	 * @param sessio sessio de la Representació
	 * @return Representació identificada per nomL i sessio
	 * @throws CDRepresentacioNoExisteix si no existeix la Representació
	 *         identificada per nomL i sessio
	 */
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

	/**
	 * Actualitza una Representació a la BD
	 * @param representacio Representació a actualitzar
	 */
	public void updateRepresentacio(Representacio representacio) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.update(representacio);
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
