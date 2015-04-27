package hibernate.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import unused.HibernateUtil;
import entities.Menu;
import entities.Plat;
import entities.Produit;
import entities.ProduitHome;
import hibernate.JPASessionUtil;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

public class PersistenceTest
{
	/*
	@Test
	public void saveProduit()
	{
		Produit produit = new Produit("typeLol2", "nomLol2", (float)3.1, new HashSet<Menu>(), new HashSet<Plat>());
		
		(new ProduitHome()).persist(produit);
	}

	@Test
	public void findById()
	{
		Produit produit = (new ProduitHome()).findById(0);
	}
	*/	
}