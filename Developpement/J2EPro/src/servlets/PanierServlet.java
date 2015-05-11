package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
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
		int removeProdId = -1;
		String msg = "";

		try
		{
			if(!request.getParameter("rem").isEmpty())
				removeProdId = Integer.parseInt(request.getParameter("rem"));
		}
		catch(Exception e)
		{
			if(e.getClass() != NumberFormatException.class && e.getClass() != NullPointerException.class)
				throw new ServletException(e);
		}

		Set<Produit> prodz = null;
		Set<Menu> menz = new HashSet<Menu>();
		Set<Plat> plaz = new HashSet<Plat>();
		
		
		Panier p = (new ProxyHome<Panier>(new PanierHome())).findById(1);
		if(p == null)
			throw new NullPointerException("pas de panier");
		
		if(removeProdId != -1) 				// on veut remove
		{
			removeProduit(removeProdId, p);
			
			/* Redirection vers l'accueil ! */
	        response.sendRedirect( "panier" );
		}
		else
		{
			
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
					
					/*else*/if(pro.getPlats() != null && pro.getPlats().size() > 0)
					{
						tmpPlaz = pro.getPlats();
						
						if(tmpPlaz.size() > 1)
							throw new ServletException("pls plats pr 1 produit ??");
						else
							plaz.add( tmpPlaz.iterator().next() );
					}
				}
			}
			
			if(plaz != null)
				msg += String.valueOf(plaz.size()) + " plats; ";
			
			if(menz != null)
				msg += String.valueOf(menz.size()) + " menus; ";
	
			request.setAttribute( "msg", msg );
			request.setAttribute( "menus", menz );
			request.setAttribute( "plats", plaz );
		
				
				//Set<Menu> m = p.get
			this.getServletContext().getRequestDispatcher( "/WEB-INF/monPanier.jsp" ).forward( request, response );
		}
	}
	
	private void removeProduit(int prodId, Panier p)
	{
		if(p != null && prodId >= 0)
		{
			PanierHome ph = new PanierHome();
			ProxyHome<Panier> prp = new ProxyHome<Panier>(ph);
			
			p.removeProduitById(prodId);
		}
	}
}
