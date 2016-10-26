package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gestionnaires")
public class Gestionnaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gestionnaire")
	private Long Id_g;
	private String login;
	private String password;
	
	
//	private List<Category> listCat;
//	
//	
//	private List<Product> listProd;
	
	
	/**
	 * Constructeur vide
	 */
	public Gestionnaire() {
		super();
	}
	
	/** Constructeur avec paramètres, sans ID
	 * @param login
	 * @param password
	 */
	public Gestionnaire(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/** Constructeur avec paramètres et ID
	 * @param id_g
	 * @param login
	 * @param password
	 */
	public Gestionnaire(Long id_g, String login, String password) {
		super();
		Id_g = id_g;
		this.login = login;
		this.password = password;
	}
	
	/** Getters & setters*/
	
	
//	public List<Category> getListCat() {
//		return listCat;
//	}
//
//	public void setListCat(List<Category> listCat) {
//		this.listCat = listCat;
//	}
//
//	public List<Product> getListProd() {
//		return listProd;
//	}
//
//	public void setListProd(List<Product> listProd) {
//		this.listProd = listProd;
//	}

	public Long getId_g() {
		return Id_g;
	}


	public void setId_g(Long id_g) {
		Id_g = id_g;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/** toString*/
	@Override
	public String toString() {
		return "Gestionnaire [Id_g=" + Id_g + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
	
	

}
