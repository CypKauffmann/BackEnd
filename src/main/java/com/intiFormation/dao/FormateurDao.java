package com.intiFormation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.intiFormation.entity.Formateur;

public interface FormateurDao extends JpaRepository<Formateur, Integer>{
	
	@Query("SELECT f FROM Formateur f LEFT JOIN FETCH f.formations")
	    List<Formateur> findAllWithFormations();

	@Transactional
	  @Modifying
	  @Query(value = "INSERT INTO tab_Formateur_Formation (id_formateur, id_formation) VALUES (?1, ?2)", nativeQuery = true)
	  public void addFormateurToFormation(int idPers, int idForm);
	
	 @Transactional
	  @Modifying
	  @Query(value = "DELETE FROM tab_Formateur_Formation WHERE id_formateur = ?1 AND id_formation = ?2", nativeQuery = true)
	  public void removeByIdFormAndIdPers(int idPers, int idForm);

	
}
