package hibernate;
import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;


public class HibernateUtilTest
{
	@Test
	public void test()
	{
		Session s = HibernateUtil.currentSession();
		if(s == null)
			fail("null pointer");
		else
			HibernateUtil.closeSession();
	}
}
