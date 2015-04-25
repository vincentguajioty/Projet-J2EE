package com.dju.entities;

// Generated Apr 24, 2015 5:08:29 PM by Hibernate Tools 4.0.0

import hibernate.JPASessionUtil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Menu.
 * @see com.dju.entities.Menu
 * @author Hibernate Tools
 */
@Stateless
public class MenuHome {

	private static final Log log = LogFactory.getLog(MenuHome.class);

	@PersistenceContext
	private EntityManager entityManager = JPASessionUtil.getEntityManager("pu_j2ee");
	private EntityTransaction tx = null;

	public void persist(Menu transientInstance) {
		log.debug("persisting Menu instance");
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			entityManager.persist(transientInstance);
			
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Menu persistentInstance) {
		log.debug("removing Menu instance");
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			entityManager.remove(persistentInstance);

			tx.commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			Menu result = entityManager.merge(detachedInstance);

			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Menu findById(MenuId id) {
		log.debug("getting Menu instance with id: " + id.getIdMenu());
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			Menu instance = entityManager.find(Menu.class, id);

			tx.commit();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}