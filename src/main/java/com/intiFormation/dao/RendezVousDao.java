package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.RendezVous;

public interface RendezVousDao extends JpaRepository<RendezVous, Integer> {
	
	public List<RendezVous> findByCommercial_idComm(int id);
	public List<RendezVous> findByPersonne_idPers(int id);

}
