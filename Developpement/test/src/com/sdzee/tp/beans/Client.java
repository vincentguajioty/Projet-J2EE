package com.sdzee.tp.beans;


public class Client {
    /* Propriétés du bean */
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String mdp;
    private String mdp2;
    private String datenaiss;

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setMDP( String mdp ) {
        this.mdp = mdp;
    }

    public String getMDP() {
        return mdp;
    }
    public void setDatenaiss( String datenaiss ) {
        this.datenaiss = datenaiss;
    }

    public String getDatenaiss() {
        return datenaiss;
    }
    public void setMDP2( String mdp2 ) {
        this.mdp2 = mdp2;
    }

    public String getMDP2() {
        return mdp2;
    }
    
}