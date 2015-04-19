package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Client;

public class CreationClient extends HttpServlet {
    /* Constantes */
    public static final String CHAMP_NOM       = "nomClient";
    public static final String CHAMP_PRENOM    = "prenomClient";
    public static final String CHAMP_ADRESSE   = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL     = "emailClient";
    public static final String CHAMP_MDP   	   = "mdpClient";
    public static final String CHAMP_MDP2      = "mdp2Client";
    public static final String CHAMP_DATENAISS = "datenaissClient";
 
    public static final String ATT_CLIENT      = "client";
    public static final String ATT_MESSAGE     = "message";
    public static final String ATT_ERREUR      = "erreur";
 
    public static final String VUE             = "/afficherClient.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );
        String mdp = request.getParameter( CHAMP_MDP );
        String mdp2 = request.getParameter( CHAMP_MDP2 );
        String datenaiss = request.getParameter( CHAMP_DATENAISS );
        

        String message;
        boolean erreur;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        

        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || mdp.trim().isEmpty() ) {
            message = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
            erreur = true;
        } 
        else if (mdp.contentEquals(mdp2))
        {
            message = "Client créé avec succès !";
            erreur = false;
        }
        else
        {
        	message = "Erreur - vos mots de passes ne sont pas identiques. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        	erreur = true;

        }
        
        
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );
        client.setMDP( mdp );
        client.setMDP2( mdp2 );
        client.setDatenaiss( datenaiss );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_ERREUR, erreur );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}