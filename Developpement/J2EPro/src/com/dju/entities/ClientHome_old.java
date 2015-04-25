package com.dju.entities;

// Generated Apr 17, 2015 5:26:36 PM by Hibernate Tools 4.0.0

import hibernate.JPASessionUtil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Client.
 * @see com.dju.entities.Client
 * @author Hibernate Tools
 */
@Stateless
public class ClientHome_old {

	private static final Log log = LogFactory.getLog(ClientHome_old.class);

	@PersistenceContext
	private EntityManager entityManager = JPASessionUtil.getEntityManager("pu_j2ee");

	public void persist(Client transientInstance) {
		log.debug("persisting Client instance");
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.persist(transientInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Client persistentInstance) {
		log.debug("removing Client instance");
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.remove(persistentInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Client merge(Client detachedInstance) {
		log.debug("merging Client instance");
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			Client result = entityManager.merge(detachedInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Client findById(Integer id) {
		log.debug("getting Client instance with id: " + id);
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			Client instance = entityManager.find(Client.class, id);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
