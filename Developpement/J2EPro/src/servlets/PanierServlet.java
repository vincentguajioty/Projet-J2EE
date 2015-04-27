package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Menu;
import entities.Panier;
import entities.PanierHome;
import entities.Plat;
import entities.Produit;
import entities.homes.ProxyHome;

public class PanierServlet extends HttpServlet
{
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String msg = "";
		
		Set<Produit> prodz = null;
		Set<Menu> menz = new HashSet<Menu>();
		Set<Plat> plaz = new HashSet<Plat>();
		
		
		Panier p = (new ProxyHome<Panier>(new PanierHome())).findById(1);
		
		if(p == null)
			throw new NullPointerException("pas de panier");
		
		if(p.getProduits() != null && p.getProduits().size() > 0)
		{
			prodz = p.getProduits();
			for (Produit pro : prodz)
			{
				Set<Menu> tmpMenz = null;
				Set<Plat> tmpPlaz = null;
				
				if(pro.getMenus() != null && pro.getMenus().size() > 0)
				{
					tmpMenz = pro.getMenus();
					
					if(tmpMenz.size() > 1)
						throw new ServletException("pls menus pr 1 produit ??");
					else
						menz.add( tmpMenz.iterator().next() );
				}
				
				if(pro.getPlats() != null && pro.getPlats().size() > 0)
				{
					tmpPlaz = pro.getPlats();
					
					if(tmpPlaz.size() > 1)
						throw new ServletException("pls plats pr 1 produit ??");
					else
						plaz.add( tmpPlaz.iterator().next() );
				}
			}
		}
		
		if(plaz == null)
			msg += "plats null; ";
		else
			msg += String.valueOf(plaz.size()) + " plats; ";
		
		if(menz == null)
			msg += "menus null; ";
		else
			msg += String.valueOf(menz.size()) + " menus; ";

		request.setAttribute( "msg", msg );
		request.setAttribute( "menus", menz );
		request.setAttribute( "plats", plaz );
		
		//Set<Menu> m = p.get
		this.getServletContext().getRequestDispatcher( "/WEB-INF/mon_panier.jsp" ).forward( request, response );
	}
}
