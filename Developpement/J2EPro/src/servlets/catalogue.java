package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Client;
import entities.ClientHome;
import entities.Menu;
import entities.Panier;
import entities.PanierHome;
import entities.Plat;
import entities.PlatHome;
import entities.PlatId;
import entities.Produit;
import entities.homes.ProxyHome;


public class catalogue extends HttpServlet {
	/* ces constantes répresentent le nom des champs du formulaire connection et autres*/
	public static final String ATT_VALEUR_MAXIMUM_PRODUIT      = "valmax";
    public static final String CHAMP_MDP    = "motdepasse";
    
    public static final String ATT_MESSAGE     = "message"; // pour afficher le message dans la vue ( JSTL )
    public static final String ATT_ERREUR      = "erreur"; // pareil version erreur
   
  
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        HashSet<Plat> p = new HashSet<Plat>();
        
        int id = 0;
        Produit produit;
        String typeCuisine;
        int nbPers;
        boolean chaud;
        String typePlat;
        String message = "";
        boolean erreur = false;
       
        // il test si les champss son vide
		p = (new ProxyHome<Plat>(new PlatHome())).findAll();
		
		if( p == null )
		{
			  message = "Erreur- il n'y a aucun produit à afficher";
	          erreur = true;
	          System.out.println(message);
		}
		else
		{
			Iterator<Plat> it = p.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			/*id2 = p.getId();
			produit = p.getProduit();
			typeCuisine = p.getTypeCuisine();
			nbPers = p.getNbPers();
			chaud = p.isChaud();
			typePlat = p.getTypePlat();
			message = "Produit 1 " + " : " + id2 + ", " + produit + ", " + typeCuisine;
	        erreur = false;
	        //on ajoute l'entité client à la session*/
				
		}
		//association des champs du formulaire avec la variable associée traitée ici 
        request.setAttribute( ATT_MESSAGE, message );
        //request.setAttribute( ATT_VALEUR_MAXIMUM_PRODUIT, valmax );
        request.setAttribute( ATT_ERREUR, erreur );
   
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
   	{
    	
   		this.getServletContext().getRequestDispatcher( "/catalogue.jsp" ).forward( request, response );
   		
HashSet<Plat> p = new HashSet<Plat>();
        
        int id = 0;
        Produit produit;
        String typeCuisine;
        int nbPers;
        boolean chaud;
        String typePlat;
        String message = "";
        boolean erreur = false;
       
        // il test si les champss son vide
		p = (new ProxyHome<Plat>(new PlatHome())).findAll();
		
		if( p == null )
		{
			  message = "Erreur- il n'y a aucun produit à afficher";
	          erreur = true;
	          System.out.println(message);
		}
		else
		{
			Iterator<Plat> it = p.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			/*id2 = p.getId();
			produit = p.getProduit();
			typeCuisine = p.getTypeCuisine();
			nbPers = p.getNbPers();
			chaud = p.isChaud();
			typePlat = p.getTypePlat();
			message = "Produit 1 " + " : " + id2 + ", " + produit + ", " + typeCuisine;
	        erreur = false;
	        //on ajoute l'entité client à la session*/
				
		}
		//association des champs du formulaire avec la variable associée traitée ici 
        request.setAttribute( ATT_MESSAGE, message );
        //request.setAttribute( ATT_VALEUR_MAXIMUM_PRODUIT, valmax );
        request.setAttribute( ATT_ERREUR, erreur );
   
    }

}