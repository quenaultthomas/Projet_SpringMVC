package fr.adaming.dao;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Category;


@Repository
public class CategoryDaoImpl implements ICategoryDao {
	
	@Autowired
	private SessionFactory sf; 
	

	@Override
	public void addCategoryDao(Category c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		
	}

	@Override
	public void delCategoryDao(long id) {
		Session s = sf.getCurrentSession();
		Category cat = (Category) s.get(Category.class, id);
		s.delete(cat);
		
	}

	@Override
	public void upCategoryDao(Category c) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(c);
	}

	@Override
	public List<Category> getAllategories() {
		Session s = sf.getCurrentSession();
		
		Query query = 
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
