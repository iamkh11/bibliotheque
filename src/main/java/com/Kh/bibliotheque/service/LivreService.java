package com.Kh.bibliotheque.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Kh.bibliotheque.entities.Genre;
import com.Kh.bibliotheque.entities.Livre;


public interface LivreService {

	Livre saveLivre(Livre l);
	Livre updateLivre(Livre l);
	void deleteLivre(Livre l);
	void deleteLivreById(Long id);
	Livre getLivre(Long id);
	List<Livre>getAllLivres();
	
	
	
	
	Page<Livre> getAllLivresParPage(int page, int size);
	
	List<Livre> findByNomLivre(String nom);
	List<Livre> findByNomLivreContains(String nom);
	List<Livre> findByNomPrix (String nom, Double prix);
	List<Livre> findByGenre (Genre genre);
	List<Livre> findByGenreIdG(Long id);
	List<Livre> findByOrderByNomLivreAsc();
	List<Livre> trierLivresNomsPrix();
	
	
}
