package hibernate.tests;

import java.util.HashSet;
import java.util.Set;






//import static org.junit.Assert.*;











import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import entities.Client;
import entities.ClientHome;
import entities.Menu;
import entities.MenuHome;
import entities.MenuId;
import entities.Panier;
import entities.PanierHome;
import entities.Plat;
import entities.PlatHome;
import entities.PlatId;
import entities.Produit;
import entities.ProduitHome;
import entities.homes.ProxyHome;

import org.junit.Test;

public class ModelTest
{
	@Test
	public void testFindAll() throws Exception
	{
		HashSet<Plat> p = (new ProxyHome<Plat>(new PlatHome())).findAll();
		if(p.size() <= 0)
			throw new Exception("plat vide ou null");
	}
	
	
	@Test
	public void testGetMenu()
	{
		Menu pl = (new MenuHome()).findById(new MenuId(1,1));
		Produit p;
		//Logger. debug("Returning default value for: ");
		
		if(pl == null)
			throw new NullPointerException("aucun plat");
		else
			if(pl.getProduit() == null)
				throw new NullPointerException("aucun produit ds le plat");
			else
				p = pl.getProduit();
		
		System.out.println("testGetMenu : {\n\t" + pl.toString() + "\n\t" + p.toString() + "\n}");
	}
	
	@Test
	public void testGetPlat()
	{
		Plat pl = (new PlatHome()).findById(new PlatId(1,1));
		Produit p = null;
		//Logger. debug("Returning default value for: ");
		
		if(pl == null)
			System.out.println("aucun plat");
		else
			if(pl.getProduit() == null)
				throw new NullPointerException("aucun produit ds le plat");
			else
				p = pl.getProduit();
		
		if(p != null)
			System.out.println("testGetPlat : {\n\t" + pl.toString() + "\n\t" + p.toString() + "\n}");
		else
			System.out.println("testGetPlat : {\n\t" + pl.toString() + "\n}");
	}

	@Test
	public void testGetProduit()
	{
		Produit p = (new ProxyHome<Produit>(new ProduitHome())).findById(1);
		Set<Menu> prod_menus = null;
		
		if(p == null)
			throw new NullPointerException("aucun produit");
		else
		{
			prod_menus = p.getMenus();
			
			if(prod_menus == null || prod_menus.size() == 0)
				throw new NullPointerException("aucun menus dans dans produit");	
		}
		
		System.out.println("testGetProduit : {\n\t" + p.toString() + "\n}");
		for (Menu m : prod_menus)
		{
			System.out.println("\t\t" + m.toString());
		}
	}

	
	@Test
	public void testGetPanier()
	{
		Panier p = (new ProxyHome<Panier>(new PanierHome())).findById(1);
		Client c = null;

		if(p == null)
			throw new NullPointerException("aucun panier");
		else
		{
			c = p.getClient();
			if(c == null)
				throw new NullPointerException("aucun client ds panier :/");
		}
			

		System.out.println("testGetPanier : {\n\t" + p.toString() + 
							"\n\t" + c.toString());

		if(p.getProduits() != null && p.getProduits().size() != 0)
		{
			Set<Produit> prodz = p.getProduits(); 
			
			for (Produit prod : prodz)
				System.out.println("\t" + prod.toString());
		}
		
		System.out.println("\n}");
	}
	
	@Test
	public void testGetClientByEmail()
	{
		Client c = (new ClientHome()).findByEmail("henri@davanture.fr");
		//Logger. debug("Returning default value for: ");
		
		if(c == null)
			throw new NullPointerException("aucun client");
		else
			System.out.println("testGetPlat : {\n\t" + c.toString() + "\n\t" + c.toString() + "\n}");
	}
	
	private void printProd(Produit p)
	{
		System.out.println("\t" + p.toString());
		for (Panier pa : p.getPaniers())
			System.out.println("\t\t" + pa.toString());
	}
	
	@Test
	public void testUpdatePanProd()
	{ // test de la liste des produits dans le panier
		/*
		final String meth = "testUpdatePanProd";
		Panier p = (new ProxyHome<Panier>(new PanierHome())).findById(1);

		if(p == null)
			throw new NullPointerException("aucun panier");
		else
		{
			printPanier(p, meth);
			p.removeProduit(p.getProduits().iterator().next());
			printPanier(p, meth);
		}
		
		System.out.println("\n}");
		*/
	}
	
	private void printPanier(Panier p, String meth)
	{
		System.out.println(meth + " : {\n\t" + p.toString() + 
				"\n\t" + p.getClient().toString());

		if(p.getProduits() != null && p.getProduits().size() > 0)
		{
			Set<Produit> prodz = p.getProduits(); 
			
			for (Produit prod : prodz)
				System.out.println("\t" + prod.toString());
		}
	}
	
	@Test
	public void testAddProdToPan()
	{
		int idPanier = 1, idPro = 6;
		ProxyHome<Panier> prh = new ProxyHome<Panier>(new PanierHome());
		Panier pa = prh.findById(idPanier);
		Produit pro = (new ProxyHome<Produit>(new ProduitHome())).findById(idPro);
		
		printPanier(pa, "testAddProdToPan");
		pa.addProduit(pro);
		
		pa = prh.findById(idPanier);
		printPanier(pa, "testAddProdToPan");
	}
	
	@Test
	public void testRemProdFromPan()
	{
		int idPanier = 1, idPro = 6;
		ProxyHome<Panier> prh = new ProxyHome<Panier>(new PanierHome());
		Panier pa = prh.findById(idPanier);
		Produit pro = (new ProxyHome<Produit>(new ProduitHome())).findById(idPro);
		
		printPanier(pa, "testRemProdFromPan");
		pa.removeProduitById(pro.getIdProduit());
		
		pa = prh.findById(idPanier);
		printPanier(pa, "testRemProdFromPan");
	}
}