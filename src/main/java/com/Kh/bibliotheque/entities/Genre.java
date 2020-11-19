package com.Kh.bibliotheque.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data


@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idG;
	
	private String nomG;
	private String descriptionG;
	
	@OneToMany (mappedBy = "genre")
	@JsonIgnore
	private List<Livre> livres;
	
	public Genre() {
		super();
		
	}
	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getNomG() {
		return nomG;
	}
	public void setNomG(String nomG) {
		this.nomG = nomG;
	}
	public String getDescriptionG() {
		return descriptionG;
	}
	public void setDescriptionG(String descriptionG) {
		this.descriptionG = descriptionG;
	}
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
