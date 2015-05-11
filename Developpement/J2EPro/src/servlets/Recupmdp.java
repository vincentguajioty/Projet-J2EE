package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.mail.*;
import javax.mail.internet.*;

import entities.Client;
import entities.ClientHome;
import entities.homes.ProxyHome;

public class Recupmdp extends HttpServlet{
	public static final String CHAMP_EMAIL     = "email";
    public static final String ATT_MESSAGE     = "message2";
    public static final String ATT_ERREUR      = "erreur";

	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /*
	         * Récupération des données saisies, envoyées en tant que paramètres de
	         * la requête GET générée à la validation du formulaire
	         */

	        String email = request.getParameter( CHAMP_EMAIL );
	        String message2="";
	        String mailcli;
	        String mdp;
	        boolean erreur = false;
	        
	        Client c = null;
	        //si lma 
	        if ( email.trim().isEmpty() ) {
	            erreur = true;
	            message2 = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"recupmdp\">Essayer encore</a> ";
	            System.out.println("do it work ?" + " " + message2);
	        }
	        else
	        {
	        	c = (new ClientHome()).findByEmail(email);
	        	if(c == null){
	        		 erreur = true;
	        		 message2="Il n'y a aucun client enregistré pour cette adresse";
	        	}
	        	else{
		        	mailcli = c.getMailCli();
		        	mdp = c.getMdpCli();
		        	    final String username = "contact@davanture.fr";
		        		final String password = "456456456a";	// Le premier qui s'amuse à utiliser ce mot de passe à des fins non respectables aura à faire à moi
		    		    	Properties props = System.getProperties();
		    		    	// laisser "mail.smtp.host" en dur
		    		    	props.put("mail.smtp.host", "ssl0.ovh.net");
		    				props.put("mail.smtp.auth", "true");
		    				props.put("mail.smtp.starttls.enable", "true");
		    				props.put("mail.smtp.port", "587");
		    		    	// javax.mail.Session pour que ça fonctionne aussi avec WebObjects
		    				Session session = Session.getInstance(props,
		    						  new javax.mail.Authenticator() {
		    							protected PasswordAuthentication getPasswordAuthentication() {
		    								return new PasswordAuthentication(username, password);
		    							}
		    				});
		    				try {
		    					 
		    					Message message = new MimeMessage(session);
		    					message.setFrom(new InternetAddress("contact@davanture.fr"));
		    					message.setRecipients(Message.RecipientType.TO,
		    						InternetAddress.parse(email));
		    					message.setSubject("Noreply Password recovery");
		    					message.setText("Here's your password : " + " <b> " + mdp +"</b>");
		    		 
		    					Transport.send(message);
		    		 
		    					System.out.println("Done");
		    					message2 = "Mail envoyé avec succès, veuillez attendre son envoi.";
		    				} catch (MessagingException e) {
		    					throw new RuntimeException(e);
		    				}
	  
	    		   
	        		
	        	}

	        }
            request.setAttribute( ATT_MESSAGE, message2 );
            request.setAttribute( ATT_ERREUR, erreur );
	        this.getServletContext().getRequestDispatcher( "/recupmdpok.jsp" ).forward( request, response );
	 }
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( "/recupmdp.jsp" ).forward( request, response );
	}

}
