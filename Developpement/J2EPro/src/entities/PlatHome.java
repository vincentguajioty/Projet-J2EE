package entities;

// Generated Apr 26, 2015 9:45:15 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.homes.AHome;

/**
 * Home object for domain model class Plat.
 * @see entities.Plat
 * @author Hibernate Tools
 */
@Stateless
public class PlatHome extends AHome<Plat>
{
	private static final Log log = LogFactory.getLog(PlatHome.class);

	public void persist(Plat transientInstance) {
		log.debug("persisting Plat instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Plat persistentInstance) {
		log.debug("removing Plat instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Plat merge(Plat detachedInstance) {
		log.debug("merging Plat instance");
		try {
			Plat result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Plat findById(PlatId id) {
		log.debug("getting Plat instance with id: " + id);
		try {
			Plat instance = entityManager.find(Plat.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Plat findById(int me) {
		// TODO Auto-generated method stub
		return null;
	}
}
