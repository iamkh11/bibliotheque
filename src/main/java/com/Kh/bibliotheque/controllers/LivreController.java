package com.Kh.bibliotheque.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Kh.bibliotheque.entities.Livre;
import com.Kh.bibliotheque.service.LivreService;

@Controller
public class LivreController {

	@Autowired
	LivreService livreService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createLivre";
	}
	
	@RequestMapping("/saveLivre")
	
	public String saveLivre(@ModelAttribute("livre") Livre livre,
							@RequestParam("date") String date,
							ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date)); livre.setDateCreation(dateCreation);
	Livre saveLivre = livreService.saveLivre(livre);
	String msg ="livre enregistré avec Id "+saveLivre.getIdLivre();
	modelMap.addAttribute("msg", msg);
	return "createLivre";
	}
	
	@RequestMapping("/ListeLivres")
	public String listeLivres(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	
	Page<Livre> livres = livreService.getAllLivresParPage(page, size);
	modelMap.addAttribute("livres", livres);
	modelMap.addAttribute("pages", new int[livres.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeLivres";
	}
	
	@RequestMapping("/supprimerLivre")
	public String supprimerLivre(@RequestParam("id") Long id,
								ModelMap modelMap,
								@RequestParam (name="page",defaultValue = "0") int page,
								@RequestParam (name="size", defaultValue = "2") int size)
	{
	livreService.deleteLivreById(id);
	Page<Livre> livres = livreService.getAllLivresParPage(page, size);
	modelMap.addAttribute("livres", livres);
	modelMap.addAttribute("pages", new int[livres.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeLivres";
	}
	
	@RequestMapping("/modifierLivre")
	public String editerLivre(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Livre l= livreService.getLivre(id);
	modelMap.addAttribute("livre", l);
	return "editerLivre";
	}
	@RequestMapping("/updateLivre")
	public String updateLivre(@ModelAttribute("livre") Livre livre,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
	//conversion de la date 
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	livre.setDateCreation(dateCreation);
	livreService.updateLivre(livre);
	List<Livre> livres = livreService.getAllLivres();
	modelMap.addAttribute("livres", livres);
	return "listeLivres";
	}

	
	
	
	
	}
	
	
	
	

