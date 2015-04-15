package com.dju.model;

import java.sql.Time;
import java.util.*;

public class Commandes
{
    public Commandes()
    {
    }

    private int id_commande;

    private boolean paiement_fait;

    private boolean livraion_domicile;

    private Time livraion_heure;

    private String etat_com;

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public boolean isPaiement_fait() {
		return paiement_fait;
	}

	public void setPaiement_fait(boolean paiement_fait) {
		this.paiement_fait = paiement_fait;
	}

	public boolean isLivraion_domicile() {
		return livraion_domicile;
	}

	public void setLivraion_domicile(boolean livraion_domicile) {
		this.livraion_domicile = livraion_domicile;
	}

	public Time getLivraion_heure() {
		return livraion_heure;
	}

	public void setLivraion_heure(Time livraion_heure) {
		this.livraion_heure = livraion_heure;
	}

	public String getEtat_com() {
		return etat_com;
	}

	public void setEtat_com(String etat_com) {
		this.etat_com = etat_com;
	}

}