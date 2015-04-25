package com.dju.entities;

// Generated Apr 24, 2015 5:08:28 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Panier generated by hbm2java
 */
@Entity
@Table(name = "Panier", catalog = "j2ee")
public class Panier implements java.io.Serializable {

	private int idPanier;
	private Client client;
	private Set<Produit> produits;

	public Panier() {
	}

	public Panier(Client client) {
		this.client = client;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_panier", unique = true, nullable = false)
	public int getIdPanier() {
		return this.idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cli")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
