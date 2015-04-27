package entities;

// Generated Apr 26, 2015 9:45:15 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	public void persist(Panier transientInstance) {
		log.debug("persisting Panier instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Panier persistentInstance) {
		log.debug("removing Panier instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Panier merge(Panier detachedInstance) {
		log.debug("merging Panier instance");
		try {
			Panier result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Panier findById(int id) {
		log.debug("getting Panier instance with id: " + id);
		try {
			Panier instance = entityManager.find(Panier.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
