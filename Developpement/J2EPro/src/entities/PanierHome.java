package entities;

// Generated Apr 26, 2015 9:45:15 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.homes.AHome;

/**
 * Home object for domain model class Panier.
 * @see entities.Panier
 * @author Hibernate Tools
 */
@Stateless
public class PanierHome extends AHome<Panier>
{
	private static final Log log = LogFactory.getLog(PanierHome.class);

	public int getLastId()
	{
		int res = -1;
		Query query =  entityManager.createNativeQuery("select id_panier from Panier order by id_panier desc limit 1");
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		res = (int)query.getSingleResult();
		tx.commit();
		return res + 1;
	}
	
	public void persist(Panier transientInstance) {
		System.out.println("persisting Panier instance");
		try {
			entityManager.persist(transientInstance);
			System.out.println("persist successful");
		} catch (RuntimeException re) {
			System.out.println("persist failed " + re.toString());
			throw re;
		}
	}
	
	public void remove(Panier persistentInstance) {
		System.out.println("removing Panier instance");
		try {
			entityManager.remove(persistentInstance);
			System.out.println("remove successful");
		} catch (RuntimeException re) {
			System.out.println("remove failed " + re.toString());
			throw re;
		}
	}

	public Panier merge(Panier detachedInstance) {
		System.out.println("merging Panier instance");
		try {
			Panier result = entityManager.merge(detachedInstance);
			if(!result.equals(detachedInstance))
			{
				System.out.println("merge: they're not equals");
				result = detachedInstance;
			}
			else
				System.out.println("merge: they're equals");
				
			System.out.println("merge successful");
			return result;
		} catch (RuntimeException re) {
			System.out.println("merge failed " + re.toString());
			throw re;
		}
	}

	public Panier findById(int id) {
		System.out.println("getting Panier instance with id: " + id);
		try {
			Panier instance = entityManager.find(Panier.class, id);
			System.out.println("get successful");
			return instance;
		} catch (RuntimeException re) {
			System.out.println("get failed " + re.toString());
			throw re;
		}
	}
	
	public int removeProd(int prodId, int panId)
	{
		int res = -1;
		Query query =  entityManager.createNativeQuery("delete from contient where id_produit = :idpr and id_panier = :idpa")
				.setParameter("idpr", prodId)
				.setParameter("idpa", panId);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		res = query.executeUpdate();
		tx.commit();
		return res;
	}
	
	public int addProd(int prodId, int panId)
	{
		int res = -1;
		Query query =  entityManager.createNativeQuery("insert into contient values(?, ?)")
				.setParameter(1, prodId)
				.setParameter(2, panId);
		EntityTransaction tx = entityManager.getTransaction();
		
		tx.begin();
		res = query.executeUpdate();
		tx.commit();
		return res;
	}
}
