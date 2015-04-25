package test.java.hibernate;

import java.util.Set;


import com.dju.entities.Menu;
import com.dju.entities.MenuHome;
import com.dju.entities.MenuId;
import com.dju.entities.Plat;
import com.dju.entities.PlatHome;
import com.dju.entities.PlatId;
import com.dju.entities.Produit;
import com.dju.entities.ProduitHome;

//import static org.junit.Assert.*;

import org.junit.Test;

public class ProduitTest
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
		Produit p = (new ProduitHome()).findById(1);
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
}