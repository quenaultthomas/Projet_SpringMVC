package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Product;


public interface IGestionnaireDao {
	
	public void addCategoryDao(Category c);
	
	public void delCategoryDao(int id);
	
	public void upCategoryDao(Category c);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
	
	public List<Product> SearchByNameCategorie(Category categorie);
	
	public List<Product > SearchByProduitSelectionneDao();
		

}
