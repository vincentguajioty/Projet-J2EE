package hibernate;

import javax.persistence.EntityManager;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

public class JPASessionUtilTest
{
	@Test
	public final void getEntityManager()
	{
		EntityManager em = JPASessionUtil.getEntityManager("pu_j2ee");
		em.close();
	}
	
	@Test(expected = javax.persistence.PersistenceException.class)
	public final void nonexistentEntityManagerName()
	{
		JPASessionUtil.getEntityManager("nonexistent");
		fail("We shouldn't be able to acquire an EntityManager here");
	}
	
	@Test
	public final void getSession()
	{
		Session session = JPASessionUtil.getSession("pu_j2ee");
		session.close();
	}
	
	@Test(expected = javax.persistence.PersistenceException.class)
	public final void nonexistentSessionName()
	{
		JPASessionUtil.getSession("nonexistent");
		fail("We shouldn't be able to acquire a Session here");
	}
}
