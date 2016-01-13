package showscom.dataLayer.dataControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDEspectacleNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlEspectacle;
import showscom.domainLayer.domainModel.Espectacle;

/**
 * Controlador de la classe Espectacle. Gestiona els accessos amb la BD
 */
public class CtrlEspectacle implements ICtrlEspectacle {

	// Instancia de la SessionFactory per connectar-se amb la BD
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona un Espectacle identificat pel seu titol guardat a la BD
	 * @param titol titol de l'Espectacle
	 * @return Espectacle identificat per titol
	 * @throws CDEspectacleNoExisteix si no existeix l'Espectacle identificat
	 *         per titol
	 */
	public Espectacle getEspectacle(String titol) throws CDEspectacleNoExisteix {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Espectacle esp = null;

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Espectacle WHERE Espectacle.titol = :titol";
			List<Object> listObj = session.createSQLQuery(sql).setParameter("titol", titol)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();

			if (listObj.size() == 1) {
				esp = (Espectacle) session.get(Espectacle.class, titol);
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

	/**
	 * Selecciona tots els Espectacles guardats a la BD
	 * @return Llista amb tots els Espectacles
	 */
	public List<Espectacle> getAllEspectacle() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Espectacle> listEsp = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			String sql = "SELECT * FROM Espectacle";
			List<Object> listObj = session.createSQLQuery(sql).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.list();

			for (Object obj : listObj) {
				Map row = (Map) obj;
				String titol = row.get("titol").toString();
				Espectacle esp = (Espectacle) session.get(Espectacle.class, titol);
				listEsp.add(esp);
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listEsp;
	}
}
