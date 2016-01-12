package showscom.dataLayer.sessionFactory;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Gestiona la creaci� de la sessi� per connectar-nos amb la BD
 */
@SuppressWarnings("unchecked")
public class SessionFactoryAdapter {

	/**
	 * Instancia de la SessionFactory
	 */
	private static final SessionFactory sessionFact;

	/**
	 * Inicialitzaci� est�tica de la inst�ncia de la SessionFactory
	 */
	static {
		List<Logger> loggers = Collections.<Logger> list(LogManager.getCurrentLoggers());
		loggers.add(LogManager.getRootLogger());
		for (Logger logger : loggers) {
			logger.setLevel(Level.OFF);
		}

		try {
			sessionFact = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * Consulta la inst�ncia de la SessionFactory
	 * @return inst�ncia de SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFact;
	}

}
