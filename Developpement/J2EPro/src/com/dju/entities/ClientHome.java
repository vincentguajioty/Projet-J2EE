package com.dju.entities;

// Generated Apr 24, 2015 5:08:29 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Client.
 * @see com.dju.entities.Client
 * @author Hibernate Tools
 */
@Stateless
public class ClientHome {

	private static final Log log = LogFactory.getLog(ClientHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Client transientInstance) {
		log.debug("persisting Client instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Client persistentInstance) {
		log.debug("removing Client instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Client merge(Client detachedInstance) {
		log.debug("merging Client instance");
		try {
			Client result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Client findById(int id) {
		log.debug("getting Client instance with id: " + id);
		try {
			Client instance = entityManager.find(Client.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
