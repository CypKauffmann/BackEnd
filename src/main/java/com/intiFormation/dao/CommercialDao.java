package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commercial;

public interface CommercialDao extends JpaRepository<Commercial, Integer> {
	
	public Commercial findByRendezVousC_idRdv(int id) ;
	public Commercial findByHistoriquesC_idHist(int id) ;

}
