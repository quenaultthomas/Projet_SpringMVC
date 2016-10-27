package fr.adaming.test;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.model.Category;
import fr.adaming.model.Product;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

public class ClasseTest {

	public static void main(String[] args) {
		String configLocation = "C:\\Users\\inti0292\\git\\Projet_SpringMVC\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		 
        ApplicationContext cxt = new FileSystemXmlApplicationContext(configLocation);
        
        IClientService clientService = (IClientService) cxt.getBean("clientServiceBean");
        
        List<Category> liste1  = clientService.GetAllCategorie();
        
        for (Category category : liste1) {
			System.out.println(category);
    	}	
			
		List<Product> liste2  = clientService.SearchByAllProduits();
		        
		 for (Product produit : liste2) {
			 System.out.println(produit);
		}
		 
		
		 List<Product> liste3  = clientService.SearchByKeyWord("moustache");
	        
		 for (Product produit : liste3) {
			 System.out.println(produit);
		}

		 		 
		 List<Product> liste4  = clientService.SearchByNameCategorie(1);
	        
	        for (Product produit : liste4) {
				System.out.println(produit);
	    	}

	}
}

