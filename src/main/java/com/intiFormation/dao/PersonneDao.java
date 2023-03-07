package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Personne;

public interface PersonneDao extends JpaRepository<Personne, Integer> {
	
	public Personne findByRendezVous_idRdv(int id); 
	public Personne findByHistoriques_idHist(int id);

}
