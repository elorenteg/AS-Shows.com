package showscom.dataLayer.sessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryAdapter {

	private static final SessionFactory sessionFact;
	
	static {
		try {
			sessionFact = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch(Throwable e) {
			System.err.println("Initial SessionFactory creation failed " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFact;
	}

}
