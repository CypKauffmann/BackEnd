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

import com.intiFormation.entity.Formation;
import com.intiFormation.service.IFormationService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormationController {

	
	@Autowired
	private IFormationService formationService;
	
	

	//afficher la liste 
	@GetMapping("/formations")
	public List<Formation> afficher()
	{
		List< Formation> formations = formationService.selectAllFormation();
	
		return formations;
	}

	//ajout 
	@PostMapping("/formations")
	public void ajouterFormation(@RequestBody Formation form)
	{
		formationService.ajout(form);
	}

	//modif
	@PutMapping("/formations")
	public void modifierFormation(@RequestBody Formation form)
	{
		formationService.modif(form);
	}

	//trouver un
	@GetMapping("/formations/{idForm}")
	public Formation selectByidForm(@PathVariable("idForm") int idForm)
	{
		Formation formation =formationService.chercherParIdidForm(idForm).get();
		
		return formation;
	}

	//suppression
	@DeleteMapping("/formations/{idForm}")
	public void deletePaiement(@PathVariable("idForm") int idForm)
	{
		formationService.suppression(idForm);
	}


}
