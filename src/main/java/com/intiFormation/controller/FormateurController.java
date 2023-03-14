package com.intiFormation.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formateur;
import com.intiFormation.service.IFormateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormateurController {
	
	@Autowired
	private IFormateurService formateurService;
	
	
	
	@GetMapping("/formateurs")
    public List<Formateur> afficherFormateurAvecFormation() {
        return formateurService.getFormateursWithFormations();
    }
	
	
	//ajout 
	@PostMapping("/formateurs")
	public void ajouterFormateur(@RequestBody Formateur form)
	{
		formateurService.ajout(form);
	}

	//modif
	@PutMapping("/formateurs")
	public void modifierFormateur(@RequestBody Formateur formateur)
	{
		formateurService.modif(formateur);
	}

	//trouver un formateur par Id
	@GetMapping("/formateurs/{idFormateur}")
	public Formateur selectByidForm(@PathVariable("idFormateur") int idFormateur)
	{
		Formateur formateur =formateurService.chercherParidFormateur(idFormateur).get();
		
		return formateur;
	}

	//suppression
	@DeleteMapping("/formateurs/{idFormateur}")
	public void deleteFormateur(@PathVariable("idFormateur") int idFormateur)
	{
		formateurService.suppression(idFormateur);
	}

	@PostMapping("/formations/{idForm}/formateurs/{idPers}")
	public ResponseEntity<String> addFormateurToFormation(@PathVariable int idForm, @PathVariable int idPers) {
	    formateurService.addFormateurToFormation(idForm, idPers);
	    return ResponseEntity.ok("Formateur ajouté avec succès à la formation");
	}

	@DeleteMapping("/formations/{idForm}/formateurs/{idPers}")
	public ResponseEntity<String> removeFormateurFromFormation(@PathVariable int idForm, @PathVariable int idPers) {
	    formateurService.removeFormateurFromFormation(idForm, idPers);
	    return ResponseEntity.ok("Formateur retiré avec succès de la formation");
	}

	
	
}
