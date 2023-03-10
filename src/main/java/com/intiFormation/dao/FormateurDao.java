package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiFormation.entity.Formateur;

public interface FormateurDao extends JpaRepository<Formateur, Integer>{
	
	@Query("SELECT f FROM Formateur f LEFT JOIN FETCH f.formations")
	    List<Formateur> findAllWithFormations();

}
