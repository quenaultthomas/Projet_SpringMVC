package fr.adaming.dao;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Category;
import fr.adaming.model.Product;


@Repository
public class GestionnaireDaoImpl implements IGestionnaireDao {
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("SELECT c FROM Category c");
		return query.list();
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> SearchByNameCategorie(Category categorie) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT c FROM Category c WHERE p.categorie.nom=:nomCategorie");
		req.setParameter("nomCategorie", categorie.getNom());
		return req.list();
		
	}

	@Override
	public List<Product> SearchByProduitSelectionneDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
