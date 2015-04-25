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
 * Home object for domain model class Plat.
 * @see com.dju.entities.Plat
 * @author Hibernate Tools
 */
@Stateless
public class PlatHome {

	private static final Log log = LogFactory.getLog(PlatHome.class);

	@PersistenceContext
	private EntityManager entityManager = JPASessionUtil.getEntityManager("pu_j2ee");
	private EntityTransaction tx = null;

	public void persist(Plat transientInstance) {
		log.debug("persisting Plat instance");
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

	public void remove(Plat persistentInstance) {
		log.debug("removing Plat instance");
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

	public Plat merge(Plat detachedInstance) {
		log.debug("merging Plat instance");
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			Plat result = entityManager.merge(detachedInstance);

			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Plat findById(PlatId id) {
		log.debug("getting Plat instance with id: " + id.getIdPlat());
		try {
			tx = entityManager.getTransaction();
		    tx.begin();
		    
			Plat instance = entityManager.find(Plat.class, id);

			tx.commit();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
