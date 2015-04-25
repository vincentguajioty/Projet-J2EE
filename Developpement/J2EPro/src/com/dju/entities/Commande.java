package com.dju.entities;

// Generated Apr 24, 2015 5:08:28 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Commande generated by hbm2java
 */
@Entity
@Table(name = "Commande", catalog = "j2ee")
public class Commande implements java.io.Serializable {

	private int idCommande;
	private Client client;
	private boolean paiementFait;
	private boolean livraisonDomicile;
	private Date livraisonHeure;
	private Integer etatCom;

	public Commande() {
	}

	public Commande(Client client, boolean paiementFait,
			boolean livraisonDomicile, Date livraisonHeure, Integer etatCom) {
		this.client = client;
		this.paiementFait = paiementFait;
		this.livraisonDomicile = livraisonDomicile;
		this.livraisonHeure = livraisonHeure;
		this.etatCom = etatCom;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_commande", unique = true, nullable = false)
	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cli")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "paiement_fait")
	public boolean isPaiementFait() {
		return this.paiementFait;
	}

	public void setPaiementFait(boolean paiementFait) {
		this.paiementFait = paiementFait;
	}

	@Column(name = "livraison_domicile")
	public boolean isLivraisonDomicile() {
		return this.livraisonDomicile;
	}

	public void setLivraisonDomicile(boolean livraisonDomicile) {
		this.livraisonDomicile = livraisonDomicile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "livraison_heure", length = 19)
	public Date getLivraisonHeure() {
		return this.livraisonHeure;
	}

	public void setLivraisonHeure(Date livraisonHeure) {
		this.livraisonHeure = livraisonHeure;
	}

	@Column(name = "etat_com")
	public Integer getEtatCom() {
		return this.etatCom;
	}

	public void setEtatCom(Integer etatCom) {
		this.etatCom = etatCom;
	}

}
