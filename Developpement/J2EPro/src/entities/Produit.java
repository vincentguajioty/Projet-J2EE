package entities;

// Generated Apr 26, 2015 9:45:15 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Produit", catalog = "j2ee")
public class Produit implements java.io.Serializable {

	private int idProduit;
	private String typeProduit;
	private String nomProduit;
	private Float prixProduit;
	private Set<Menu> menus = new HashSet<Menu>(0);
	private Set<Plat> plats = new HashSet<Plat>(0);
	private Set<Panier> paniers = new HashSet<Panier>(0);

	public Produit() {
	}

	public Produit(String typeProduit, String nomProduit, Float prixProduit,
			Set<Menu> menus, Set<Plat> plats, Set<Panier> paniers) {
		this.typeProduit = typeProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.menus = menus;
		this.plats = plats;
		this.paniers = paniers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_produit", unique = true, nullable = false)
	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	@Column(name = "type_produit", length = 25)
	public String getTypeProduit() {
		return this.typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	@Column(name = "nom_produit", length = 25)
	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	@Column(name = "prix_produit", precision = 12, scale = 0)
	public Float getPrixProduit() {
		return this.prixProduit;
	}

	public void setPrixProduit(Float prixProduit) {
		this.prixProduit = prixProduit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produit")
	public Set<Plat> getPlats() {
		return this.plats;
	}

	public void setPlats(Set<Plat> plats) {
		this.plats = plats;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "contient", catalog = "j2ee", joinColumns = { @JoinColumn(name = "id_produit", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_panier", nullable = false, updatable = false) })
	public Set<Panier> getPaniers() {
		return this.paniers;
	}

	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", typeProduit="
				+ typeProduit + ", nomProduit=" + nomProduit + ", prixProduit="
				+ prixProduit + "]";
	}

}
