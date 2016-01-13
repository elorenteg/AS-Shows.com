package showscom.dataLayer.dataControllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import showscom.dataLayer.exceptions.CDEntradaNoExisteix;
import showscom.dataLayer.sessionFactory.SessionFactoryAdapter;
import showscom.domainLayer.dataInterface.ICtrlEntrada;
import showscom.domainLayer.domainModel.Entrada;

/**
 * Controlador de la classe Entrada. Gestiona els accessos amb la BD
 */
public class CtrlEntrada implements ICtrlEntrada {

	/**
	 * Instancia de la SessionFactory per connectar-se amb la BD
	 */
	private final SessionFactory sessionFactory = SessionFactoryAdapter.getSessionFactory();

	/**
	 * Selecciona una Entrada identificada pel seu identificador guardada a la
	 * BD
	 * @param id identificador de l'Entrada
	 * @return Entrada identificada per id
	 * @throws CDEntradaNoExisteix si no existeix l'Entrada identificada per id
	 */
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

	/**
	 * Inserta una Entrada a la BD
	 * @param entrada Entrada a insertar
	 */
	public void insertEntrada(Entrada entrada) {
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
