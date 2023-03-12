package com.intiFormation.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.intiFormation.entity.Participant;

public interface ParticipantDao extends JpaRepository<Participant, Integer>{


	@Query("SELECT p FROM Participant p  JOIN FETCH p.formations")
	public List<Participant> findAllWithParticipants();
	
	  @Query("SELECT p FROM Participant p WHERE p.formations IS EMPTY")
	  public List<Participant> findParticipantsWithoutFormation();
	  
	  @Transactional
	  @Modifying
	  @Query(value = "INSERT INTO tab_Part_Formation (id_participant, id_Formation) VALUES (?1, ?2)", nativeQuery = true)
	  public void addParticipantToFormation(int idPers, int idForm);

	  
	  @Transactional
	  @Modifying
	  @Query(value = "DELETE FROM tab_Part_Formation WHERE id_participant = ?1 AND id_Formation = ?2", nativeQuery = true)
	  public void removeByIdFormAndIdPers(int idPers, int idForm);

	  
	  
	  

}
