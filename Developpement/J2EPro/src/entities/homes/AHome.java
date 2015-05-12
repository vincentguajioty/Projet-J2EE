package entities.homes;
import hibernate.JPASessionUtil;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public abstract class AHome<T> implements IHome<T>
{
    @PersistenceContext
    protected EntityManager entityManager;
    protected EntityTransaction tx;

    public AHome()
    {
    	//System.out.println("went there : AHome()");
    	entityManager = JPASessionUtil.getEntityManager("pu_j2ee");
    }

    
    public final void startTx() {
    	tx = entityManager.getTransaction();
		tx.begin();
    }

    public final void commitTx() {
        tx.commit();
    }

    public abstract void persist(T me);

    public abstract void remove(T me);

    public abstract T merge(T me);
    public abstract HashSet<T> findAll();

    public abstract T findById(int me);
    
    public EntityManager getEm()
	{
		return entityManager;
	}
	
}