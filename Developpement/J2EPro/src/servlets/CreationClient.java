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

import entities.Client;
import entities.ClientHome;
import entities.homes.ProxyHome;
public class CreationClient extends HttpServlet {
    /* ces constantes répresentent le nom des champs du formulaire inscription*/
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
    
    /**
     * @brief convertion date sous forme de strind en format date
     * @param haha:date sous forme string (jj/mm/aaaa)
     * @return date type Date
     */
    public Date stringToDate (String haha ){
    	DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
    	Date date = null;
    		try {
			date = format.parse(haha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return date;
    }
    
    	 
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
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
        
        Date michel = stringToDate(datenaiss);

        String message;
        boolean erreur;
        // verification de la date een commentaire parcequee ca marchee pas.
         /*   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String s = args[0];
            Date date = null;
            try {
                date = format.parse(s);
                String t = format.format(d);
                if(t.compareTo(s) !=  0)
    	            message = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
    	            erreur = true;
                else
                    System.out.println("valide");
            } catch (Exception e) {
                    System.out.println("Exception");
            }*/
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        
        Client client = null;
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || mdp.trim().isEmpty() ) {
            message = "Erreur- Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
            erreur = true;
        } 
        else if (mdp.contentEquals(mdp2))
        {
            message = "Client créé avec succès !";
            erreur = false;
            
            //creation du client
            client = new Client();
            client.setNomCli( nom );
            client.setPrenomCli( prenom );
            client.setAdresseCli( adresse );
            client.setTelCli( telephone );
            client.setMailCli( email );
            client.setMdpCli( mdp );
            client.setDatenaiss( michel );
            
            //on ajoute le client a la bdd
            
            ClientHome clientH = new ClientHome();
            ProxyHome<Client> proxyClientH = new ProxyHome<Client>(clientH);
            proxyClientH.persist(client);
            
        }
        else
        {
        	message = "Erreur - vos mots de passes ne sont pas identiques. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        	erreur = true;

        }
        
        
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_ERREUR, erreur );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
         
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( "/creerClient.jsp" ).forward( request, response );
	}
}