package sport_system.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 


public class HibernateUtil {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			/* Hibernate 3 的寫法
			return new Configuration().configure().buildSessionFactory();
			*/
			/* Hibernate 4.0, 4.1, 4.2 的寫法
			 Configuration configuration = new Configuration();
             configuration.configure();
             serviceRegistry = new ServiceRegistryBuilder().applySettings(
                 configuration.getProperties()).buildServiceRegistry();
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             return sessionFactory; 
			 */
			// Hibernate 4.3 的寫法
			 Configuration configuration = new Configuration();	//hibernate.properties
            configuration.configure();	//hibernate.cfg.xml
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory; 
			 
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}