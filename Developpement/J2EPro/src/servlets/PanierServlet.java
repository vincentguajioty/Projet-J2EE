package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Client;
import entities.Menu;
import entities.Panier;
import entities.PanierHome;
import entities.Plat;
import entities.Produit;
import entities.homes.ProxyHome;

public class PanierServlet extends HttpServlet
{
	public final String PANIER_COOKIE_NAME = "localPanierCookie";
	private HttpServletResponse mresponse;
	
	private void easyLog(String msg, String meth)
	{
		System.out.println("[" + meth + "] " + msg);
	}
	
	/**
	 * @brief Recupere le Panier du client dans la session,
	 *  ou en cree un nouveau
	 * @param session La session courante
	 * @return le panier existant ou un nouveau
	 */
	private Panier recupererPanier(HttpSession session)
	{
		easyLog("laaaaaaaa", "recupererPanier");
		Panier p = null;
		String msg ="";
		
		if(session.getAttribute(Conn.ATT_SESSION_CLIENT) != null)
		{ // oui -> possede panier?
			Client c = (Client) session.getAttribute(Conn.ATT_SESSION_CLIENT);
			if(c.getPanier() != null)
			{ // oui -> on le recup
				p = c.getPanier();
				msg = "Panier client récupéré";
			}
			else
			{ // non -> on le cree
				p = new Panier();
				
				msg = "Aucun panier dans client, panier créé";
				// puis on l'ajoute au cookie
				//createPanCookie(p.getIdPanier());
			}
		}
		else
		{ // non -> on cree un panier
			p = new Panier();
			msg = "Aucune session, panier créé";
			// puis on l'ajoute au cookie
			//createPanCookie(p.getIdPanier());
		}
		
		//Panier p = (new ProxyHome<Panier>(new PanierHome())).findById(1);

		easyLog(msg, "recupererPanier");
		return p;
	}
	
	private void createPanCookie(int panId, HttpServletRequest request)
	{
		String msg = "";
		String cookieValue = "";
		Cookie localPanierCookie = null;
		if(mresponse != null)
		{
			// on cherche si il existe
			localPanierCookie = getCookieValue(request);
			
			if(localPanierCookie == null)
			{
				// Creation d’un cookie et ajout à la réponse
				localPanierCookie = new Cookie(PANIER_COOKIE_NAME, String.valueOf(panId));
				msg = "Cookie créé (panId=" + panId + ")";
			}
			else
			{
				localPanierCookie.setValue(String.valueOf(panId));
				msg = "Cookie modifié (panId=" + panId + ")";
			}
			localPanierCookie.setMaxAge(60*60*24*7); // 1 semaine
			localPanierCookie.setPath("/J2EPro/"); // Autorisation sur toute l’application
			
			
			mresponse.addCookie(localPanierCookie);
			msg = "Cookie créé (panId=" + panId + ")";
		}
		else
			msg = "mresponse null...";
		
		easyLog(msg, "recupererPanier");
	}
	
	private Cookie getCookieValue(HttpServletRequest request)
	{
		// on check si panier dans cookie
		// Récupération d’un cookie
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		String cookieValue = "";
		if(cookies != null && cookies.length > 0)
		{
			for (int i=0; i<cookies.length; i++) 
			{
				cookie = cookies[i];
				if (cookie.getName().equals(PANIER_COOKIE_NAME))
				{
					cookieValue = cookie.getValue();
					break;
				}
			}
		}
		
		if(cookieValue.equals(""))
			cookie = null;
		
		return cookie;
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		int removeProdId = -1;
		String msg = "";
		Set<Produit> prodz = null;
		Set<Menu> menz = new HashSet<Menu>();
		Set<Plat> plaz = new HashSet<Plat>();
		Panier p = null, mergedP = null;
		mresponse = response;

		// verification du parametre de suppression de produit
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
		// ----------------------------------------------------

		// on check si panier dans cookie
		// Récupération d’un cookie
		String cookieValue = "";
		try
		{
			cookieValue = getCookieValue(request).getValue();
		}
		catch(NullPointerException npe)
		{
			cookieValue = "";
		}
		
		
		
		if(!cookieValue.equals(""))
		{
			easyLog("!cookieValue.equals('')", "doGet");
			
			int panId = -1;
			try
			{
				panId = Integer.parseInt(cookieValue);
			}
			catch(Exception e)
			{
				if(e.getClass() != NumberFormatException.class)
					throw new ServletException(e);
			}
			if(panId != -1)
				p = (new ProxyHome<Panier>(new PanierHome())).findById(panId);
			
			if(p == null)
				p = new Panier();
		}
		else
			p = recupererPanier(request.getSession());
		
		// A partir d'ici on a notre panier, on l'ajoute en base
		ProxyHome<Panier> php = new ProxyHome<Panier>(new PanierHome());
		
		if(p == null)
			throw new ServletException("probleme de panier!");
		
		if(p.getIdPanier() == -1)
		{
			p.setIdPanier( ((PanierHome)php.getHome()).getLastId() );
			//php.persist(p);
		}
		
		mergedP = php.merge(p);
		
		// on ajoute le cookie
		createPanCookie(mergedP.getIdPanier(), request);
				
		if(removeProdId != -1) 				// on veut remove
		{
			removeProduit(removeProdId, p);
			
			/* Redirection vers l'accueil ! */
	        mresponse.sendRedirect( "panier" );
		}
		else
		{
			if(mergedP.getProduits() != null && mergedP.getProduits().size() > 0)
			{
				prodz = mergedP.getProduits();
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
		
			this.getServletContext().getRequestDispatcher( "/monPanier.jsp" ).forward( request, mresponse );
		}
	}
	
	/**
	 * @brief Enleve le produit d'id prodId du panier p
	 * @param prodId L'id du Produit que l'on souhaite retirer du panier
	 * @param p Le Panier duquel on veut retirer le produit
	 */
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
