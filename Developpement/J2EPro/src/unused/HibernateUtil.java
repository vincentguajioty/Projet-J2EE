package unused;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @brief Creates a SessionFactory object which in turn can open up new Session
 */
public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static
	{
		try
		{
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).buildServiceRegistry();
		    
		    // Cree la SessionFactory
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Problème de configuration : "
										+ ex.getMessage(), ex);
		}
	}

	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() throws HibernateException
	{
		Session s = (Session) session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null)
		{
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException
	{
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}
}
