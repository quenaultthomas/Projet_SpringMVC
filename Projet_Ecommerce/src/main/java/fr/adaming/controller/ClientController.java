package fr.adaming.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.adaming.model.Category;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneDeCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Product;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping(value = "/Ecommerce/client")
@SessionAttributes({"MonPanier","client"})

public class ClientController {

	@Autowired
	private IClientService clientService;

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	Map<Integer, LigneDeCommande> Article = new HashMap<Integer, LigneDeCommande>();


	@ModelAttribute("MonPanier")
	public Panier panier() {
		Panier panier = new Panier();

		panier.setCoutTotal(0);
		panier.setArticle(Article);

		return panier;

	}
	
	@ModelAttribute("client")
	public Client client() {
		Client client = new Client();

		client.setName(null);
		client.setMail(null);
		client.setAdresse(null);
		client.setTelephone(null);

		return client;

	}

	
	@RequestMapping(value = "/listeCat", method = RequestMethod.GET)
	public String getAllCategories(ModelMap model) {
		List<Category> liste = clientService.GetAllCategorie();
		model.addAttribute("listeCat", liste);
		return "listeCat";
	}

	@RequestMapping(value = "/listeProd/{id_cat}", method = RequestMethod.GET)
	public String getProduitsByIdCategorie(@PathVariable("id_cat") int id_cat, ModelMap model) {
		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);
		return "listeProd";
	}

	@RequestMapping(value = "/retourListeCat", method = RequestMethod.GET)
	public String RetourListeCat(ModelMap model) {

		List<Category> liste = clientService.GetAllCategorie();
		model.addAttribute("listeCat", liste);
		return "listeCat";
	}
	
	@RequestMapping(value = "/retourListeProd/{id_cat}", method = RequestMethod.GET)
	public String RetourListeProd(ModelMap model, @PathVariable("id_cat") int id_cat) {

		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);
		return "listeCat";
	}

	@RequestMapping(value = "/retourAccueil", method = RequestMethod.GET)
	public String RetourAccueil(@ModelAttribute("client") Client client,ModelMap model) {
		
		model.addAttribute("entete", "Bienvenue monsieur " + client.getName());
		model.addAttribute("salutation",
				"Nous vous souhaitons une bonne journée.");
		return "home";
	}

	@RequestMapping(value = "/AjouterAuPanier/{id_p}/{qte}/{id_cat}", method = RequestMethod.GET)
	public String AjouterAuPanier(@ModelAttribute("MonPanier") Panier panier, @PathVariable("id_p") int id_p,
			@PathVariable("qte") int qte, @PathVariable("id_cat") int id_cat, ModelMap model) {

		// Recherche du produit par IdProduit
		Product prod = clientService.SearchByIdProduct(id_p);

		LigneDeCommande lcomm = Article.get(prod.getId_p());

		if (lcomm == null) {

			// création de la ligne de commande
			LigneDeCommande ligneCommandeNew = new LigneDeCommande();

			ligneCommandeNew.setPrix(prod.getPrix());
			ligneCommandeNew.setQuantité(qte);
			ligneCommandeNew.setProduit(prod);

			Article.put(prod.getId_p(), ligneCommandeNew);
			
			panier.getLigneCommande().add(ligneCommandeNew);

		} else {
			lcomm.setQuantité(lcomm.getQuantité() + qte);
			
			
		}

		double coutPanier = 0;
		
		for (LigneDeCommande ligne : Article.values()) {
			coutPanier += ligne.getPrix() * ligne.getQuantité();
		}

		 panier.setCoutTotal(coutPanier);
		
		System.out.println("le cout du panier est " +coutPanier);
		
		////////////////////////////////////////////////////////////////////////////////////////////////

		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);

		return "listeProd";

	}

	@RequestMapping(value = "/voirPanier", method = RequestMethod.GET)
	public String VoirPanier(@ModelAttribute("MonPanier") Panier panier,@ModelAttribute("client") Client client, ModelMap model) {

		List<LigneDeCommande> liste = panier.getLigneCommande();

				
		model.addAttribute("ListeArticle", liste);
		model.addAttribute("panier", panier);
		
		model.addAttribute("entete", "Panier de monsieur : " + client.getName());
		model.addAttribute("salutation",
				"Pnsez à en acheter toujours plus.");

		return "panier";

	}
	
	@RequestMapping(value="/formulaire", method=RequestMethod.GET)
	public String initForm(ModelMap model){
		
		model.addAttribute("client", new Client());
		
		model.addAttribute("entete", "Bienvenue, Merci de renseigner les informations suivantes");
		model.addAttribute("salutation",
				"Ces informations sont nécessaire au bon fonctionnement de notre site. Elles ne seront ni dévoilées ni divulguées à des fins commerciales");
		
		return "ajouterClient";
	}
	
	//Methode pour soumettre le formulaire
	@RequestMapping(value="/ajouter", method=RequestMethod.POST)
	public String ajouterClient(@ModelAttribute("MonPanier") Panier panier,@ModelAttribute("client") Client client, ModelMap model){
		
		Client cl = new Client();
		
		cl.setName(client.getName());
		cl.setMail(client.getMail());
		cl.setAdresse(client.getAdresse());
		cl.setTelephone(client.getTelephone());
		
		model.addAttribute("client", cl);
		
		
		
		model.addAttribute("entete", "Bienvenue monsieur " + client.getName());
		model.addAttribute("salutation",
				"Nous vous souhaitons une bonne journée.");

		return "home";
		
	}
		
		@RequestMapping(value="/ValiderCommande", method=RequestMethod.POST)
		public String ValiderCommande(@ModelAttribute("MonPanier") Panier panier,@ModelAttribute("client") Client client,
				ModelMap model){
					
			
			System.out.println("le nom est : " + client.getName());
			
			Client cl =new Client();
			
			cl.setName(client.getName());
			cl.setMail(client.getMail());
			cl.setAdresse(client.getAdresse());
			cl.setTelephone(client.getTelephone());
			
			System.out.println(cl);
			
			Commande commande = clientService.passerCommande(panier, cl);
			
			
			model.addAttribute("entete", "Bienvenue aux client du Site FRANCIS LA LEGENDE");
			model.addAttribute("salutation",
					"Vous allez pouvoir acheter des produits ayant appartenues à notre legende à tous.");

			return "home";
		
	}
	
	
}
