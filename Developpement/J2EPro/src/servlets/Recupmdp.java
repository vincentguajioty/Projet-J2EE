package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	        if ( email.trim().isEmpty() ) {
	            erreur = true;
	            message2 = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"recupmdp\">Essayer encore</a> ";
	            System.out.println("do it work ?" + " " + message2);
	        }
	        else
	        {
	        	c = (new ProxyHome<Client>(new ClientHome())).findByEmail(email);
	        	if(c == null)
					throw new NullPointerException("Mail inconnus " + email + " " );
	        	mailcli = c.getMailCli();
	        	mdp = c.getMdpCli();
	        	if (email.contentEquals(mailcli))
	        	{
	    		    String emailFrom = "\"moi Himself\"<contact@davanturee.fr>";
	    		    String emailTo = email;		
	    		    String messageText = "Voici votre mot de passe, veuillez en prendre soin. " + " " + mdp;
	    		    String subject = "Noreply, récupération du mot de passe";
	    		    
	    		    try 
	    		    {   		
	    		    	Properties props = System.getProperties();
	    		    	// laisser "mail.smtp.host" en dur
	    		    	props.put("mail.smtp.host", "ssl0.ovh.net");
	    		    	// javax.mail.Session pour que ça fonctionne aussi avec WebObjects
	    		    	javax.mail.Session maSession = javax.mail.Session.getDefaultInstance(props, null);
	    		    	MimeMessage message = new MimeMessage(maSession);
	    		 
	    		    	message.setFrom(new InternetAddress(emailFrom));
	    		    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
	    		    	//message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailCc));
	    		    	message.setSubject(subject);
	    		    	message.setText(messageText);
	    		 
	    			Transport.send(message);    		   		
	    		    } 
	    		    catch (AddressException e) {
	    		    	e.printStackTrace();
	    		    } 
	    		    catch (MessagingException e) {
	    		    	e.printStackTrace();
	    		    }
	        		
	        	}
	        	else
	        	{
	        		message2 = "Il n'y a aucun client enregistré pour cette adresse";
	        		erreur = true;
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
