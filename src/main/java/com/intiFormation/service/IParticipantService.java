package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Participant;

public interface IParticipantService {

	public void addParticipant(Participant participant);
	public void deleteParticipant(int id);
	public void updateParticipant(Participant participant);
	public List<Participant> getAllParticipants();
	public List<Participant> getFormationsWithParticipants();
	//public List<Participant> GetParticipantsByFormation_idForm(int idForm);
	
}
