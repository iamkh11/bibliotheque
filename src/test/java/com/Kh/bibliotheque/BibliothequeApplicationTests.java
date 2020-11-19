package com.Kh.bibliotheque;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.Kh.bibliotheque.entities.Genre;
import com.Kh.bibliotheque.entities.Livre;
import com.Kh.bibliotheque.repos.LivreRepository;
import com.Kh.bibliotheque.service.LivreService;

@SpringBootTest
class BibliothequeApplicationTests {
	
	@Autowired
	private LivreRepository livreRepository;
	
	@Autowired
	private LivreService livreService;
	

	
	@Test
	public void testCreateLivre() {
		Livre liv = new Livre("Vingt mille lieues sous les mers",75.0,new Date());
		livreRepository.save(liv);
	}
	
	
	@Test
	public void testFindLivre() {
		Livre l = livreRepository.findById(3L).get(); 
		System.out.println(l);
	}
	
	@Test
	public void testUpdateLivre() {
		Livre l = livreRepository.findById(3L).get(); 
		l.setPrixLivre(40.35);
		livreRepository.save(l);
		
		System.out.println(l);
	}
		
	@Test
	public void testDeleteLivre() {
		
		livreRepository.deleteById(3L); 
		
	}
	
	@Test
	public void testFindAllLivres() {
		
		List<Livre> livres = livreRepository.findAll();
		
		for (Livre l:livres) {
			System.out.println(l);
		}
	
	}
	
	
	@Test
	public void testFindByNomLivreContains()
	{
	
	Page<Livre> livres = livreService.getAllLivresParPage(0,2);
	System.out.println(livres.getSize());
	System.out.println(livres.getTotalElements()); System.out.println(livres.getTotalPages());
	livres.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	
	
	@Test
	public void testFindLivreByNom()
	{ 
		List<Livre> livs = livreRepository.findByNomLivre("nomm"); 
		for ( Livre l: livs)
		{
		System.out.println(l);
		}
	}
	@Test
	public void testFindLivreByNomContains()
	{ 
		List<Livre> livs = livreRepository.findByNomLivreContains("m"); 
		for ( Livre l: livs)
		{
		System.out.println(l);
		}
	}
		
		@Test
		public void testFindByNomPrix()
		{
		List<Livre> livs = livreRepository.findByNomPrix("nomm", 80.00);
		for (Livre l : livs)
		{
		System.out.println(l);
		}
		}
		
		@Test
		public void testfindByGenre()
		{
		Genre G = new Genre();
		G.setIdG(1L);
		List<Livre> livs = livreRepository.findByGenre(G);
		for (Livre l : livs)
		{
		System.out.println(l);
		}
		}
		
		@Test
		public void findByGenreIdG()
		{
		List<Livre> livs = livreRepository.findByGenreIdG(1L);
		for (Livre l : livs)
		{
		System.out.println(l);
		}
		}
		
		@Test
		public void testfindByOrderByNomLivreAsc()
		{
		List<Livre> livs =
		livreRepository.findByOrderByNomLivreAsc();
		for (Livre l : livs)
		{
		System.out.println(l);
		}
		}
		
		@Test
		public void testTrierLivresNomsPrix()
		{
		List<Livre> livs = livreRepository.trierLivresNomsPrix();
		for (Livre l : livs)
		{
		System.out.println(l);
		}
		}
		
	}




