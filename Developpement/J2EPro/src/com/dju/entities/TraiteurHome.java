package com.dju.entities;

// Generated Apr 24, 2015 5:08:29 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Traiteur.
 * @see com.dju.entities.Traiteur
 * @author Hibernate Tools
 */
@Stateless
public class TraiteurHome {

	private static final Log log = LogFactory.getLog(TraiteurHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Traiteur transientInstance) {
		log.debug("persisting Traiteur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Traiteur persistentInstance) {
		log.debug("removing Traiteur instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Traiteur merge(Traiteur detachedInstance) {
		log.debug("merging Traiteur instance");
		try {
			Traiteur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Traiteur findById(int id) {
		log.debug("getting Traiteur instance with id: " + id);
		try {
			Traiteur instance = entityManager.find(Traiteur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
