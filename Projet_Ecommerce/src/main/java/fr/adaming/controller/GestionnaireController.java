package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.service.IGestionnaireService;


@Controller
@RequestMapping(value="/Ecommerce/gestio")
public class GestionnaireController {
	
	@Autowired
	private IGestionnaireService gestioService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)		
	public String welcomeGestio(ModelMap gestio){
		
		gestio.addAttribute("entete","Bienvenue Gestionnaire!");
		gestio.addAttribute("login", "Veuillez vous identifier");
		
		return "homeG";
		
	}
	
	

}
