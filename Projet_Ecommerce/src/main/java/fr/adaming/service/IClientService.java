package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Product;

public interface IClientService {
	
public List<Product> SearchByAllProduits();
	
	public List<Product> SearchByKeyWord(String keyWord);
	
	public List<Product> SearchByNameCategorie(Category categorie);

	public List<Product > SearchByProduitSelectionne();
	
	public List<Category> GetAllCategorie();
	
	public void addClient(Client cl);

}
