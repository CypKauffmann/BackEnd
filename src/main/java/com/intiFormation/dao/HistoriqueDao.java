package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Historique;

public interface HistoriqueDao extends JpaRepository<Historique, Integer> {
	
	public List<Historique> findByPersonne_idPers(int id);

}
