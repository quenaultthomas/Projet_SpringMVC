package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Product;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByAllProduits() {
		Session s = sf.getCurrentSession();
		
		Query reqAllProduit = s.createQuery("SELECT p FROM Product p");
		return reqAllProduit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByKeyWord(String keyWord) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT p FROM Product p WHERE p.nom like:kw or p.description like:kw");
		req.setParameter("kw", "%" + keyWord + "%");
		return req.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchByNameCategorie(int  id_cat) {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("SELECT p FROM Product p WHERE p.ID_CATEGORIE=:id");
		req.setParameter("id", id_cat);
		return req.list();
		
	}

	@Override
	public List<Product> SearchByProduitSelectionne() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> GetAllCategorie() {
		Session s = sf.getCurrentSession();
		
		Query req = s.createQuery("select c from Category c");
		return req.list();
	}

	@Override
	public void addClient(Client cl) {
		Session s = sf.getCurrentSession();
		
		s.persist(cl);
		
	}

}

