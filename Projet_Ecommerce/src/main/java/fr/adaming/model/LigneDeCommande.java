package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ligneDeCommandes")
public class LigneDeCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_LigneDeCommande;
	@Column
	private int quantit�;
	@Column
	private int prix;
	
	
//	@ManyToOne
//	@JoinColumn(name = "id_produit")
//	private Produit produit;
	
	
	/**
	 * 
	 */
	public LigneDeCommande() {
		super();
	}


	/**
	 * @param quantit�
	 * @param prix
	 */
	public LigneDeCommande(int quantit�, int prix) {
		super();
		this.quantit� = quantit�;
		this.prix = prix;
	}


	/**
	 * @param id_LigneDeCommande
	 * @param quantit�
	 * @param prix
	 */
	public LigneDeCommande(Long id_LigneDeCommande, int quantit�, int prix) {
		super();
		this.id_LigneDeCommande = id_LigneDeCommande;
		this.quantit� = quantit�;
		this.prix = prix;
	}


	/**
	 * @return the id_LigneDeCommande
	 */
	public Long getId_LigneDeCommande() {
		return id_LigneDeCommande;
	}


	/**
	 * @param id_LigneDeCommande the id_LigneDeCommande to set
	 */
	public void setId_LigneDeCommande(Long id_LigneDeCommande) {
		this.id_LigneDeCommande = id_LigneDeCommande;
	}


	/**
	 * @return the quantit�
	 */
	public int getQuantit�() {
		return quantit�;
	}


	/**
	 * @param quantit� the quantit� to set
	 */
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}


	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LigneDeCommande [id_LigneDeCommande=" + id_LigneDeCommande + ", quantit�=" + quantit� + ", prix=" + prix
				+ "]";
	}
	
	
	

}
