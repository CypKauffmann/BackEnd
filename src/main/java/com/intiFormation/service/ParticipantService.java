package com.intiFormation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.FormationDao;
import com.intiFormation.dao.ParticipantDao;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Participant;

@Service
public class ParticipantService implements IParticipantService {

	@Autowired
	private ParticipantDao participantDao;
	
	@Autowired
	private FormationDao formatiodao;

	
	public void addParticipant(Participant participant) {
		participantDao.save(participant);
	}

	public void deleteParticipant(int id) {
		participantDao.deleteById(id);
	}

	public void updateParticipant(Participant participant) {
		participantDao.save(participant);
	}

	public List<Participant> getAllParticipants() {
		return participantDao.findAll();
	}
	
	public List<Participant> getFormationsWithParticipants()
	{
		return participantDao.findAllWithParticipants();
	}
	
	public List<Participant> getParticipantsWithoutFormation() {
	    return participantDao.findParticipantsWithoutFormation();
	  }
	
	@Transactional
	public void addParticipantToFormation(int idForm, int idPers) {
	    participantDao.addParticipantToFormation(idPers, idForm);
	}

	public void removeParticipantFromFormation(int idForm, int idPers) {
	    // Appel de la méthode removeByIdFormAndIdPers du dao participantDao
	    participantDao.removeByIdFormAndIdPers(idPers, idForm);
	  }

	
	
	
	


}
	
	
