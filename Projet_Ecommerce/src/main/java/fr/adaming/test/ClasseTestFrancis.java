package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClasseTestFrancis {

	public static void main(String[] args) {
		String configLocation = "C:\\Users\\inti0297\\git\\Projet_SpringMVC\\Projet_Ecommerce\\src\\main\\webapp\\WEB-INF\\application-context.xml";
		 
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);

       
	}

}
