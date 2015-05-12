package entities.homes;

import java.util.*;

import entities.AbstractEntity;

public class ProxyHome<T> implements IHome<T>
{
	private AHome<T> delegate;
    
	public ProxyHome(AHome<T> ah)
    {
    	delegate = ah;
    }

    public void persist(T me)
    {
    	delegate.startTx();
    	delegate.persist(me);
    	delegate.commitTx();
    }

    public void remove(T me)
    {
    	delegate.startTx();
    	delegate.remove(me);
    	delegate.commitTx();
    }

    public T merge(T me)
    {
    	T o;
    	delegate.startTx();
    	o = delegate.merge(me);
    	delegate.commitTx();
    	
    	return o;
    }

    public T findById(int me)
    {
    	T o;
    	delegate.startTx();
    	o = delegate.findById(me);
    	delegate.commitTx();
    	
    	return o;
    }
	//what
    public T findByEmail(String email)
    {
    	T o;
    	delegate.startTx();
    	o = delegate.findByEmail(email);
    	delegate.commitTx();
    	
    	return o;
    }
    public HashSet<T> findAll()
    {
    	HashSet<T> o;
    	delegate.startTx();
    	o = delegate.findAll();
    	delegate.commitTx();
    	 
    	return o;
    }
	//what
    public AHome<T> getHome()
    {
    	return delegate;
    }
}