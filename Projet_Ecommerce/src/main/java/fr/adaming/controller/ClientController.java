package fr.adaming.controller;

import java.util.ArrayList;
import java.util.Calendar;
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


/**
 * 
 * @author inti0292
 * Controller concernant la boutique et les actions que peux effectuer le client 
 *
 */

@Controller
@RequestMapping(value = "/Ecommerce/client")
@SessionAttributes({ "MonPanier", "client", "MaCommande" })

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

	
	/**
	 * Définition du model attribute Panier, nécessaire pour la mémorisation des elements lors de la navigation
	 */
	@ModelAttribute("MonPanier")
	public Panier panier() {
		Panier panier = new Panier();

		panier.setCoutTotal(0);
		panier.setArticle(Article);

		return panier;

	}

	/**
	 * Définition du model attribute Client, nécessaire pour la mémorisation des elements lors de la navigation
	 */
	@ModelAttribute("client")
	public Client client() {
		Client client = new Client();

		client.setId_client(0);
		client.setName(null);
		client.setMail(null);
		client.setAdresse(null);
		client.setTelephone(null);

		return client;

	}
	/**
	 * Définition du model attribute Commande, nécessaire pour la mémorisation des elements lors de la navigation
	 */
	@ModelAttribute("commande")
	public Commande commande() {
		Commande com = new Commande();

		com.setDateDeCommande(null);
		com.setClient(null);

		return com;

	}

	
	/**
	 * methode permettant l'affichage dynamique des catégories sur la page "listecat"
	 */
	@RequestMapping(value = "/listeCat", method = RequestMethod.GET)
	public String getAllCategories(ModelMap model) {
		List<Category> liste = clientService.GetAllCategorie();
		model.addAttribute("listeCat", liste);
		return "listeCat";
	}

	/**
	 * methode permettant l'affichage des produits en fonction de la catégorie sélectionnée, sur la page listeprod
	 */
	@RequestMapping(value = "/listeProd/{id_cat}", method = RequestMethod.GET)
	public String getProduitsByIdCategorie(@PathVariable("id_cat") int id_cat, ModelMap model) {
		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);
		return "listeProd";
	}

	
	/**
	 * methode de retour à la liste des catégories 
	 */
	@RequestMapping(value = "/retourListeCat", method = RequestMethod.GET)
	public String RetourListeCat(ModelMap model) {

		List<Category> liste = clientService.GetAllCategorie();
		model.addAttribute("listeCat", liste);
		return "listeCat";
	}

	/**
	 *methode permattant le retour a la page de listeprod
	 */
	@RequestMapping(value = "/retourListeProd/{id_cat}", method = RequestMethod.GET)
	public String RetourListeProd(ModelMap model, @PathVariable("id_cat") int id_cat) {

		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);
		return "listeCat";
	}

	/**
	 * methode permettant le retour à l'accueil
	 */
	@RequestMapping(value = "/retourAccueil", method = RequestMethod.GET)
	public String RetourAccueil(@ModelAttribute("client") Client client, ModelMap model) {

		model.addAttribute("entete", "Bienvenue monsieur " + client.getName());
		model.addAttribute("salutation", "Nous vous souhaitons une bonne journée.");
		return "home";
	}

	/**
	 * methode permettant l'ajour au panier des articles sléectionnés par le client
	 * ajout et addition des quantité sur les lignes de commandes si nécessaire
	 * calcul du cout du panier 
	 */
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

		System.out.println("le cout du panier est " + coutPanier);

		////////////////////////////////////////////////////////////////////////////////////////////////

		List<Product> liste = clientService.SearchByIdCategorie(id_cat);
		model.addAttribute("listeProd", liste);

		return "listeProd";

	}
	/**
	 * methode permettant l'affichage du panier du client
	 */
	@RequestMapping(value = "/voirPanier", method = RequestMethod.GET)
	public String VoirPanier(@ModelAttribute("MonPanier") Panier panier, @ModelAttribute("client") Client client,
			ModelMap model) {

		List<LigneDeCommande> liste = panier.getLigneCommande();

		model.addAttribute("ListeArticle", liste);
		model.addAttribute("panier", panier);

		model.addAttribute("entete", "Panier de monsieur : " + client.getName());
		model.addAttribute("salutation", "Pensez à en acheter toujours plus.");

		return "panier";

	}

	/**
	 * methode permettant l'initialisation du formulaire d'ajout du client
	 */
	@RequestMapping(value = "/formulaire", method = RequestMethod.GET)
	public String initForm(ModelMap model) {

		model.addAttribute("client", new Client());

		model.addAttribute("entete", "Bienvenue, Merci de renseigner les informations suivantes");
		model.addAttribute("salutation",
				"Ces informations sont nécessaire au bon fonctionnement de notre site. Elles ne seront ni dévoilées ni divulguées à des fins commerciales");

		return "ajouterClient";
	}

	/**
	 * methode gérant la formulaire d'ajout client
	 */
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public String ajouterClient(@ModelAttribute("MonPanier") Panier panier, @ModelAttribute("client") Client client,
			ModelMap model) {

		Client cl = new Client();

		cl.setName(client.getName());
		cl.setMail(client.getMail());
		cl.setAdresse(client.getAdresse());
		cl.setTelephone(client.getTelephone());

		model.addAttribute("client", cl);

		model.addAttribute("entete", "Bienvenue monsieur " + client.getName());
		model.addAttribute("salutation", "Nous vous souhaitons une bonne journée.");

		return "home";

	}

	/**
	 * 
	 * methode peremettant la validation de la commande client 
	 * 
	 * récupération des lignes de commandes et des informations clients
	 * 
	 * 
	 * 
	 * @param commande
	 * @param panier
	 * @param client
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ValiderCommande", method = RequestMethod.POST)
	public String ValiderCommande(@ModelAttribute("commande") Commande commande,
			@ModelAttribute("MonPanier") Panier panier, @ModelAttribute("client") Client client, ModelMap model) {

		System.out.println("le nom est : " + client.getName());

		Client cl = new Client();

		cl.setName(client.getName());
		cl.setMail(client.getMail());
		cl.setAdresse(client.getAdresse());
		cl.setTelephone(client.getTelephone());

		System.out.println(cl);

		commande = clientService.passerCommande(panier, cl);
		
				
		model.addAttribute("commande", commande);
		model.addAttribute("entete", "Bienvenue aux client du Site FRANCIS LA LEGENDE");
		model.addAttribute("salutation",
				"Vous allez pouvoir acheter des produits ayant appartenues à notre legende à tous.");

		return "home";

	}

	
	/**
	 * methode permettant la supression article par article des elements du panier
	 */
	@RequestMapping(value = "/deleteArticle/{id_p}", method = RequestMethod.GET)
	public String deleteArticle(@ModelAttribute("MonPanier") Panier panier, @ModelAttribute("client") Client client,
			@PathVariable("id_p") int id_p, ModelMap model) {

		List<LigneDeCommande> liste = panier.getLigneCommande();

		Product prod = clientService.SearchByIdProduct(id_p);

		LigneDeCommande lcomm = Article.get(prod.getId_p());

		if (lcomm.getQuantité() > 0) {

			lcomm.setQuantité(lcomm.getQuantité() - 1);

		} else {

			liste.remove(lcomm);

		}

		double coutPanier = 0;

		for (LigneDeCommande ligne : Article.values()) {
			coutPanier += ligne.getPrix() * ligne.getQuantité();
		}

		panier.setCoutTotal(coutPanier);

		model.addAttribute("ListeArticle", liste);
		model.addAttribute("panier", panier);

		model.addAttribute("entete", "Panier de monsieur : " + client.getName());
		model.addAttribute("salutation", "Pensez à en acheter toujours plus.");

		return "panier";
	}

	/**
	 * methode permettant l'affichage de la commande 
	 * en rajoutant les information client, les lignes de commande commandés
	 * 
	 * en récupérant la date d'émission de la commande
	 */
	@RequestMapping(value = "/afficherCommande", method = RequestMethod.GET)
	public String affficherCommande(@ModelAttribute("commande") Commande commande,
			@ModelAttribute("MonPanier") Panier panier, @ModelAttribute("client") Client client, ModelMap model) {

		List<LigneDeCommande> liste = panier.getLigneCommande();

		double coutPanier = 0;

		for (LigneDeCommande ligne : Article.values()) {
			coutPanier += ligne.getPrix() * ligne.getQuantité();
		}

		panier.setCoutTotal(coutPanier);
		
		Calendar c = Calendar.getInstance();

		commande.setDateDeCommande(c.getTime());

		
		System.out.println("la date de la commande est : " + commande.getDateDeCommande());

		model.addAttribute("panier", panier);
		model.addAttribute("commande", commande);
		model.addAttribute("ListeArticle", liste);
		
		return "commande";

	}

}
