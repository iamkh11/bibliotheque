package com.Kh.bibliotheque.entities;

import org.springframework.data.rest.core.config.Projection;



	@Projection(name = "nomLivre", types = { Livre.class })
	public interface LivreProjection {
	
		public String getNomLivre();

	}
