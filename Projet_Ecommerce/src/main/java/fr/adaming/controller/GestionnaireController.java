package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.IGestionnaireService;


@Controller
@RequestMapping(value="/Ecommerce/gestio")
public class GestionnaireController {
	
	@Autowired
	private IGestionnaireService gestioService;

}
