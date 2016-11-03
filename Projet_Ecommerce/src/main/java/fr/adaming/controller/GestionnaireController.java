package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.adaming.model.Category;
import fr.adaming.model.Product;
import fr.adaming.service.IGestionnaireService;


@Controller
@RequestMapping(value="/Ecommerce/gestio")
public class GestionnaireController {
	
	/** Déclaration du gestionnaireService pour faire appel aux méthodes de la couche service*/
	@Autowired
	private IGestionnaireService gestioService;
	
	
	
	/** Setters du gestionnaireService
	 * @param gestioService the gestioService to set
	 */
	public void setGestioService(IGestionnaireService gestioService) {
		this.gestioService = gestioService;
	}

	


	@RequestMapping(value="/index", method=RequestMethod.GET)		
	public String welcomeGestio(ModelMap gestio){
		
		gestio.addAttribute("entete","Bienvenue Gestionnaire!");
		
		return "homeG";
		
	}
	
	@RequestMapping(value = "/listeCatG", method = RequestMethod.GET)
	public String getAllCategories(ModelMap gestio) {
		List<Category> liste = gestioService.getAllCategoriesService();
		gestio.addAttribute("listeCatG", liste);
		return "listeCatG";
	}
	
	
	@RequestMapping(value = "/listeProdG", method = RequestMethod.GET)
	public String getProduitsByIdCategorie(ModelMap gestio) {
		List<Product> liste = gestioService.getAllProductsService();
		gestio.addAttribute("listeProdG", liste);
		return "listeProdG";
	}
	
	
	@RequestMapping(value="/retourAccueilG", method=RequestMethod.GET)		
	public String retourAccueilGestio(ModelMap gestio){
		
		gestio.addAttribute("entete","Bienvenue Gestionnaire!");
		gestio.addAttribute("login", "Veuillez vous identifier");
		
		return "homeG";
		
	}
	
	@RequestMapping(value="/formulaireCat", method=RequestMethod.GET)
	public String formulaireCat(ModelMap gestio){
		
		gestio.addAttribute("categorie", new Category());
		
		return "ajouterCat";
		
	}
	
	@RequestMapping(value="/ajouterCat", method=RequestMethod.POST)
	public String ajouterCat(@ModelAttribute("categorie")Category cat, ModelMap gestio){
		
		if(cat.getId_c()==0){
			
			gestioService.addCategoryService(cat);
			
		}else{
			gestioService.upCategoryService(cat);	
		}
		
		
		List<Category> liste=gestioService.getAllCategoriesService();
		gestio.addAttribute("listeCatG", liste);
		
		return "listeCatG";
	}
	
	
	@RequestMapping(value="/modifCat", method=RequestMethod.GET)
	public String formulaireModifCat(int IdCat, ModelMap gestio){
		
		Category cat = gestioService.getCategoryByIdService(IdCat);
		gestio.addAttribute("categorie",cat);
		
		return "ajouterCat";
	}
	
	@RequestMapping(value="/supprimerCat/{catId}", method=RequestMethod.GET)
	public String supprimerCat(@PathVariable ("catId") int IdCat, ModelMap gestio){
		
		Category cat = gestioService.getCategoryByIdService(IdCat);
		this.gestioService.delCategoryService(IdCat);
		
		List<Category> liste=gestioService.getAllCategoriesService();
		gestio.addAttribute("listeCatG", liste);
		
		return "listeCatG";
		
	}
	
	@RequestMapping(value="/formulaireProd", method=RequestMethod.GET)
	public String formulaireProd(ModelMap gestio){
		
		gestio.addAttribute("produit", new Product());
		
		List<Category> liste=gestioService.getAllCategoriesService();
		gestio.addAttribute("listeCatG", liste);
		
		return "ajouterProd";
		
	}
	
	@RequestMapping(value="/ajouterProd", method=RequestMethod.POST)
	public String ajouterProd(@ModelAttribute("produit")Product prod, ModelMap gestio){
		
		if(prod.getId_p()==0){
			
			gestioService.addProductService(prod);
			
		}else{
			gestioService.upProduitService(prod);	
		}
		
		
		List<Product> liste=gestioService.getAllProductsService();
		gestio.addAttribute("listeProdG", liste);
		
		return "listeProdG";
	}
		
	
	@RequestMapping(value="/modifierProd", method=RequestMethod.GET)
	public String formulaireModifProd(int IdProd, ModelMap gestio){
		
		Product prod = gestioService.getProductByIdService(IdProd);
		gestio.addAttribute("produit",prod);
		
		List<Category> liste=gestioService.getAllCategoriesService();
		gestio.addAttribute("listeCatG", liste);
		
		return "ajouterProd";
	}
	
	@RequestMapping(value="/supprimerProd/{prodId}", method=RequestMethod.GET)
	public String supprimerProd(@PathVariable ("prodId") int IdProd, ModelMap gestio){
		
		Product prod = gestioService.getProductByIdService(IdProd);
		this.gestioService.delProduitService(IdProd);
		
		List<Product> liste=gestioService.getAllProductsService();
		gestio.addAttribute("listeProdG", liste);
		
		return "listeProdG";
		
	}
	
	
	@RequestMapping(value="/rechercherFormProd", method=RequestMethod.GET)
	public String rechercherFormProd(ModelMap gestio){
		
	
		gestio.addAttribute("produit", new Product());
		
		
		return "rechercherProdG";
		
	}
	
	
	@RequestMapping(value="/rechercherProd", method=RequestMethod.POST)
	public String rechercherProd(@ModelAttribute("produit") Product prod, ModelMap gestio){
		
	
		
		List<Product> liste=gestioService.SearchByKeyWordsProductService(prod.getKeyWord());
		gestio.addAttribute("resultG", liste);
		
		return "resultG";
		
	}
	
	
	
	
	
	
	
	
	

}
