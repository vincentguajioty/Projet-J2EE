package test.java.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dju.entities.Client;
import com.dju.entities.Commande;
import com.dju.entities.Panier;

public class ClientTest
{
	SessionFactory _factory;

	@BeforeMethod
	public void setup()
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
		srBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
		_factory = configuration.buildSessionFactory(serviceRegistry);
	}

	@AfterMethod
	public void shutdown()
	{
		_factory.close();
	}

	@Test
	public void testSaveClient()
	{
		Session session = _factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Client client = new Client(new Panier(), "nomclient1", "prenomclient1", "adresseclient1", (long)1.1, "123lol", "mailcli1@lol.com", new Date(), new HashSet<Panier>(), new HashSet<Commande>());
		session.save(client);
		
		tx.commit();
		session.close();
	}
}