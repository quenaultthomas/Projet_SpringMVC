package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Category;


public interface ICategoryDao {
	
	public void addCategoryDao(Category c);
	
	public void delCategoryDao(long id);
	
	public void upCategoryDao(Category c);
	
	public List<Category> getAllategories();
	
	public Category getCategoryById(long id);
		

}
