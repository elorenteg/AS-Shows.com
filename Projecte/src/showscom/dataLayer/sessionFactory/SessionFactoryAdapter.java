package showscom.dataLayer.sessionFactory;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("unchecked")
public class SessionFactoryAdapter {

	private static final SessionFactory sessionFact;

	private static List<Logger> loggers;

	static {
		loggers = Collections.<Logger> list(LogManager.getCurrentLoggers());
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

	public static SessionFactory getSessionFactory() {
		return sessionFact;
	}

}
