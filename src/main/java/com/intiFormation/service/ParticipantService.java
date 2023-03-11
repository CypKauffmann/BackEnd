package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intiFormation.dao.ParticipantDao;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Participant;

@Service
public class ParticipantService implements IParticipantService {

	@Autowired
	private ParticipantDao participantDao;

	
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
	
//	public List<Participant> GetParticipantsByFormation_idForm(int idForm) {
//		return participantDao.findByFormation_idForm(idForm);
//	}

}
	
	
