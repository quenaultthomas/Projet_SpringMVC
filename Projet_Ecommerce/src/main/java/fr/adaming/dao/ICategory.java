package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Category;


public interface ICategory {
	
	public void addCategoryDao(Category c);
	
	public void delCategoryDao(Category c);
	
	public Category upCategoryDao(Category c);
	
	public List<Category> getAllategories();
	
	public Category getCategoryById(long id);
		

}
