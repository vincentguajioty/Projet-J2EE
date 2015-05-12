package entities;

// Generated Apr 26, 2015 9:45:15 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entities.homes.AHome;

/**
 * Home object for domain model class Menu.
 * @see entities.Menu
 * @author Hibernate Tools
 */ 
@Stateless
public class MenuHome extends AHome<Menu>
{
	private static final Log log = LogFactory.getLog(MenuHome.class);

	public void persist(Menu transientInstance) {
		log.debug("persisting Menu instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Menu persistentInstance) {
		log.debug("removing Menu instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			Menu result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Menu findById(MenuId id) {
		log.debug("getting Menu instance with id: " + id);
		try {
			Menu instance = entityManager.find(Menu.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Menu findById(int me) {
		// TODO Auto-generated method stub
		return null;
	}
}
