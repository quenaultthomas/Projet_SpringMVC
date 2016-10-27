package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Category;
import fr.adaming.model.Product;

public interface IGestionnaireService {
	
	public void addCategoryDao(Category c);
	
	public void delCategoryDao(int id);
	
	public void upCategoryDao(Category c);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
	
	
	public void addCategoryService(Category c);
	
	
	public List<Product > SearchByProduitService();

}
