package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Client;
import entities.ClientHome;
import entities.Menu;
import entities.Panier;
import entities.PanierHome;
import entities.Plat;
import entities.Produit;
import entities.homes.ProxyHome;


public class Connexion extends HttpServlet {
	public static final String CHAMP_EMAIL      = "email";
    public static final String CHAMP_MDP    = "motdepasse";
    
    public static final String ATT_CLIENT      = "client";
    public static final String ATT_MESSAGE     = "message";
    public static final String ATT_ERREUR      = "erreur";
    
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String email = request.getParameter( CHAMP_EMAIL );
        String mdp = request.getParameter( CHAMP_MDP );
        

        String message;
       
		Set<Client> client = new HashSet<Client>();
        
		Client c = (new ProxyHome<Client>(new ClientHome())).findByemail(1);
		
		if(p == null)
			throw new NullPointerException("Identifiants inconnus");
		
		
        boolean erreur;
        if ( email.trim().isEmpty() || mdp.trim().isEmpty() ) {
            message = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de connexion.";
            erreur = true;
        } 
        else if (mdp.contentEquals(mdp2))
        {
            message = "Connecté";
            erreur = false;
            
            //on ajoute le client a la bdd
            
        }
        
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
   	{
   		this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
   	}
}
