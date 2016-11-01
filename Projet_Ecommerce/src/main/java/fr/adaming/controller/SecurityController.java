package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SecurityController {
	
	@RequestMapping(value="/loginG", method=RequestMethod.GET)
	public String login(){
		
		return "loginG";
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		
		return "loginG";
		
	}

}
