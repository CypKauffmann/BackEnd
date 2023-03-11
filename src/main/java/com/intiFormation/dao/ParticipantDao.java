package com.intiFormation.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.intiFormation.entity.Participant;

public interface ParticipantDao extends JpaRepository<Participant, Integer>{


	@Query("SELECT p FROM Participant p  JOIN FETCH p.formations")
	public List<Participant> findAllWithParticipants();

//	public List<Participant> findByFormation_idForm(int id );

	

}
