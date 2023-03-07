package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commercial;

public interface CommercialDao extends JpaRepository<Commercial, Integer> {
	
	public Commercial findByRendezVous_idRdv(int id) ;
	public Commercial findByHistoriques_idHist(int id) ;

}
