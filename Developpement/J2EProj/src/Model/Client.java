
import java.util.*;

public class Client
{
    public Client()
    {
    }

    private int id_cli;
    private String nom_cli;
    private String prenom_cli;
    private String adresse_cli;
    private String tel_cli;
    private String mdp_cli;
    private String mail_cli;
    private Date datenaiss;
    
	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getPrenom_cli() {
		return prenom_cli;
	}

	public void setPrenom_cli(String prenom_cli) {
		this.prenom_cli = prenom_cli;
	}

	public String getAdresse_cli() {
		return adresse_cli;
	}

	public void setAdresse_cli(String adresse_cli) {
		this.adresse_cli = adresse_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}

	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}

	public String getMdp_cli() {
		return mdp_cli;
	}

	public void setMdp_cli(String mdp_cli) {
		this.mdp_cli = mdp_cli;
	}

	public String getMail_cli() {
		return mail_cli;
	}

	public void setMail_cli(String mail_cli) {
		this.mail_cli = mail_cli;
	}

	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
}