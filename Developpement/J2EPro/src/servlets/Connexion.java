package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Connexion {
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
        boolean erreur;
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
   	{
   		this.getServletContext().getRequestDispatcher( "/connexion.jsp" ).forward( request, response );
   	}
}
