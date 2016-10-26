package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Product;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientDao clientDao;


	@Override
	public List<Product> SearchByAllProduits() {
		return clientDao.SearchByAllProduits();
	}

	@Override
	public List<Product> SearchByKeyWord(String keyWord) {
		return clientDao.SearchByKeyWord(keyWord);
	}

	@Override
	public List<Product> SearchByNameCategorie(Category categorie) {
		return clientDao.SearchByNameCategorie(categorie);
	}

	@Override
	public List<Product> SearchByProduitSelectionne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> GetAllCategorie() {
		return clientDao.GetAllCategorie();
	}

	@Override
	public void addClient(Client cl) {
		clientDao.addClient(cl);
		
	}

}
