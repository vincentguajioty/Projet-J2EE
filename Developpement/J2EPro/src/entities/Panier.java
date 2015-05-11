package entities;

// Generated Apr 26, 2015 11:07:20 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private Set<Client> clients = new HashSet<Client>(0); // shouldn't be there
	private Set<Produit> produits = new HashSet<Produit>(0);
	private Set<Produit> produitsToRem = new HashSet<Produit>();

	public Panier() {
	}

	public Panier(Client client, Set<Client> clients, Set<Produit> produits) {
		this.client = client;
		this.clients = clients;
		this.produits = produits;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "panier")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "paniers")
	public Set<Produit> getProduits() {
		return this.produits;
	}
	
	public void addProduit(Produit p)
	{
		if(!this.produits.contains(p))
			this.produits.add(p);
		
		int res = (new PanierHome()).addProd(p.getIdProduit(), idPanier);
		if(res == 0)
			System.out.println("aucune ligne ajoutée");
		else
			System.out.println(String.valueOf(res) +  " lignes ajoutées");
	}

	private void removeProduit(Produit p)
	{
		if(p != null && this.produits.contains(p))
		{
			this.produits.remove(p);
			int res = (new PanierHome()).removeProd(p.getIdProduit(), idPanier);
			if(res == 0)
				System.out.println("aucune ligne enlevée");
			else
				System.out.println(String.valueOf(res) +  " lignes enlevées");
		}
		else
			System.out.println("Produit pas dans panier...");
		//produitsToRem.add(p);
	}
	
	/*
	public Set<Produit> getProduitsToRem() {
		return produitsToRem;
	}

	public void setProduitsToRem(Set<Produit> produitsToRem) {
		this.produitsToRem = produitsToRem;
	}
	 */
	public void removeProduitById(int prodId)
	{
		Produit toRemove = null;
		for (Produit p : this.produits)
		{
			if(p.getIdProduit() == prodId)
			{
				toRemove = p;
				break;
			}
		}
		
		removeProduit(toRemove);
	}
	
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", client=" + client + "]";
	}

}
