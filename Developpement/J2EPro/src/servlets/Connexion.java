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
	public static final String CHAMP_EMAIL      = "emailClient";
    public static final String CHAMP_MDP    = "motdepasse";
    
    public static final String ATT_CLIENT      = "client";
    public static final String ATT_MESSAGE     = "message";
    public static final String ATT_ERREUR      = "erreur";
    
    public static final String VUE             = "/connecteok.jsp";
   
  
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        /* l'utilisateur rentre ses infos e connection*/
        // le controleur les récupère
        String email = request.getParameter( CHAMP_EMAIL );
        String mdp = request.getParameter( CHAMP_MDP );
        
        String mdpcli;
        String mailcli;
        String message;
        boolean erreur;
        
        Client c = null;
        // il test si les champss son vide
		if(email.trim().isEmpty() || mdp.trim().isEmpty() )
		{
			  message = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"connexion\">Cliquez ici</a> pour accéder au formulaire de connexion";
	          erreur = true;
		}
		else
		{
			// on récupère un client en fonction de l'e-mail
			c = (new ProxyHome<Client>(new ClientHome())).findByEmail(email);
			System.out.println();
			if(c == null)
				throw new NullPointerException("Identifiants inconnus " + email + " " );
			
			mailcli = c.getMailCli();
			mdpcli = c.getMdpCli();
		

			if ( mdp.contentEquals(mdpcli)   )
			{
				message = "Vous êtes maintenant connecté ";

		        erreur = false;
		        
				
			}
			else
			{
				//System.out.println(mdp + " t" + mdpcli);
			  message = "Mauvais mot de passe <br> <a href=\"connexion\">Cliquez ici</a> pour accéder au formulaire de connexion";
			  erreur = true;
			}

		}
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_ERREUR, erreur );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
   
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
   	{
   		this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
   	}
}
