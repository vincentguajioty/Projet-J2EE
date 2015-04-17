package test.java.hibernate;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dju.entities.Menu;
import com.dju.entities.Plat;
import com.dju.entities.Produit;

public class Test
{
	public static void main(String[] args) throws HibernateException
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("j2ee");
		EntityManager em = emf.createEntityManager();
		
		List<Produit> items= em.createQuery("SELECT i FROM Produit i").getResultList();
		
		/*
		Query query = em.createQuery("SELECT a FROM Author a WHERE a.lastName IS NULL OR LOWER(a.lastName) = LOWER(:lastName)"); 
		query.setParameter("lastName", lastName); 
		List<Author> authors = query.getResultList(); 
		*/
		
		em.close();
		emf.close();
		/*
		// INSERTING
		Session session = HibernateUtil.currentSession();
		   
		Transaction tx = session.beginTransaction();
		double lol = 1.1;

		Produit contact = new Produit("typeLol0", "nomLol0", (float)lol, new HashSet<Menu>(), new HashSet<Plat>());
		session.save(contact);

		contact = new Produit("typeLol1", "nomLol1", (float)lol+1, new HashSet<Menu>(), new HashSet<Plat>());
		
		tx.commit();

		HibernateUtil.closeSession();
		*/
		/*
		// UPDATING
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		TContact contact =
		(TContact) session.load(TContact.class, new Integer(1));
		
		contact.setPrenom("Jacques");
		session.save(contact);
		
		tx.commit();
		
		HibernateUtil.closeSession();
		*/
		
		/*
		// READING
		List list = session.find("from TContact where nom like '%t'");
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
		  TContact contact = (TContact)it.next();
		  System.out.println(contact.getNom());
		}
		
		HibernateUtil.closeSession();
		*/
		
	}
}