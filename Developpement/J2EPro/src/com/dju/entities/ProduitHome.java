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
 * Home object for domain model class Produit.
 * @see com.dju.entities.Produit
 * @author Hibernate Tools
 */
@Stateless
public class ProduitHome
{
	private static final Log log = LogFactory.getLog(ProduitHome.class);

	@PersistenceContext
	private EntityManager entityManager = JPASessionUtil.getEntityManager("pu_j2ee");

	public void persist(Produit transientInstance)
	{
		log.debug("persisting Produit instance");
		try
		{
			//Get transaction
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.persist(transientInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("persist successful");
		}
		catch (RuntimeException re)
		{
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Produit persistentInstance)
	{
		log.debug("removing Produit instance");
		try
		{
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			entityManager.remove(persistentInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("remove successful");
		}
		catch (RuntimeException re)
		{
			log.error("remove failed", re);
			throw re;
		}
	}

	public Produit merge(Produit detachedInstance)
	{
		log.debug("merging Produit instance");
		try
		{
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			Produit result = entityManager.merge(detachedInstance);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public Produit findById(Integer id)
	{
		log.debug("getting Produit instance with id: " + id);
		try
		{
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			
			Produit instance = entityManager.find(Produit.class, id);
			
			transaction.commit();
			entityManager.close();
			
			log.debug("get successful");
			return instance;
		}
		catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
}
