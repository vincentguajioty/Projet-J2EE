package hibernate.tests;

import java.util.Set;






//import static org.junit.Assert.*;







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
		Produit p;
		//Logger. debug("Returning default value for: ");
		
		if(pl == null)
			throw new NullPointerException("aucun plat");
		else
			if(pl.getProduit() == null)
				throw new NullPointerException("aucun produit ds le plat");
			else
				p = pl.getProduit();
		
		System.out.println("testGetPlat : {\n\t" + pl.toString() + "\n\t" + p.toString() + "\n}");
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
		Client c = (new ProxyHome<Client>(new ClientHome())).findByEmail("henri@davanture.fr");
		//Logger. debug("Returning default value for: ");
		
		if(c == null)
			throw new NullPointerException("aucun client");
		else{
			System.out.println("testGetPlat : {\n\t" + c.toString() + "\n\t" + c.toString() + "\n}");
		}
		

	}
}