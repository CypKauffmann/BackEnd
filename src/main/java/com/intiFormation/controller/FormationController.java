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
import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;
import com.intiFormation.service.IFormationService;
import com.intiFormation.service.IParticipantService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class FormationController {

	
	@Autowired
	private IFormationService formationService;

	@Autowired
	private IParticipantService participantService;



	
	//afficher la liste 
	@GetMapping("/formations")
	public List<Formation> afficher()
	{
		List< Formation> formations = formationService.selectAllFormation();
	
		return formations;
	}
	
	
	/*@GetMapping("/formationsAvecPaiements")
	public List<Formation> getAllFormationsWithPaiements() 
	{
		List<Formation> formations=formationService.selectAllFormation();
	 
	    for (Formation formation : formations)
	    {
	    	List<Paiement> paiements = formation.getPaiements();
	    	formation.setPaiements(paiements);
	    }
	    return formations;
	}*/
	

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



    @GetMapping("/participants-formateurs")
    public List<Formation> getAllFormationsWithParticipantsAndFormateurs() {
        return formationService.getAllFormationsWithParticipantsAndFormateurs();
    }

    @GetMapping("/participants-sans-formation")
    public List<Participant> getParticipantsWithoutFormation() {
      return participantService.getParticipantsWithoutFormation();
    }
    
	

	
	@GetMapping("/formations/participants/{idForm}")
	public List<Participant> getParticipantsByFormation(@PathVariable int idForm) {
	    Formation formation = formationService.recupererParId(idForm);
	    List<Participant> participants=formation.getParticipants();
	    return participants;
	}
	
	
	@GetMapping("/formations/{id}/paiements")
    public List<Paiement> getPaiementsByFormationId(@PathVariable int id) {
        return formationService.getPaiementsByFormation(id);
    }
	
	
	@GetMapping("/formations/paiements/{idForm}")
	public List<Paiement> getPaiementsByFormation(@PathVariable int idForm) {
	    Formation formation = formationService.recupererParId(idForm);
	    List<Paiement> paiements=formation.getPaiements();	   
	    return paiements;
	}
	
	
}
