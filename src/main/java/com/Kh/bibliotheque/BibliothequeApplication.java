package com.Kh.bibliotheque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.Kh.bibliotheque.entities.Livre;
import com.Kh.bibliotheque.service.LivreService;


 @SpringBootApplication
 public class BibliothequeApplication implements CommandLineRunner {
	
	/* @Autowired
	 LivreService livreService;*/
	 
	  
	 @Autowired
	 private RepositoryRestConfiguration repositoryRestConfiguration;
	 
	 public static void main(String[] args) {
	 SpringApplication.run(BibliothequeApplication.class, args);
	 }
	 
	 @Override
	 public void run(String... args) throws Exception {
	 repositoryRestConfiguration.exposeIdsFor(Livre.class);
	 }
	 
	 
}
	
	 
	
	 
	/* @Override
	 public void run(String... args) throws Exception {
		 livreService.saveLivre(new Livre("Les fous du roi", 80.0, new Date()));
		 livreService.saveLivre(new Livre("Là-bas", 32.5, new Date()));
		 livreService.saveLivre(new Livre("Faust", 19.5, new Date()));
	 }*/
	 
	 
		 
		 
		 
		 
		 
		 
