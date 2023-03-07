package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Participant;
import com.intiFormation.service.IParticipantService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/participants")
public class ParticipantController {

	@Autowired
	private IParticipantService participantService;

	@GetMapping("/")
	public List<Participant> getAllParticipants() {
		return participantService.getAllParticipants();
	}

	@PostMapping("/")
	public void addParticipant(@RequestBody Participant participant) {
		participantService.addParticipant(participant);
	}

	@DeleteMapping("/{id}")
	public void deleteParticipant(@PathVariable int id) {
		participantService.deleteParticipant(id);
	}

	@PutMapping("/")
	public void updateParticipant(@RequestBody Participant participant) {
		participantService.updateParticipant(participant);
	}
}