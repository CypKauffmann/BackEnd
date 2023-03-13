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
import com.intiFormation.service.IPaiementService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PaiementController {
	
@Autowired
private IPaiementService paiementService;


//afficher la liste des paiements
@GetMapping("/paiements")
public List<Paiement> afficher()
{
	List< Paiement> paiements = paiementService.selectAllPaiement();
	
	for (Paiement paiement : paiements) {
        Participant participant = paiement.getParticipant();
        paiement.setParticipant(participant);
    }
	return paiements;
}



//ajout d'un paiement
@PostMapping("/paiements")
public void ajouterPaiement(@RequestBody Paiement paie)
{
	paiementService.ajout(paie);
}

//modif
@PutMapping("/paiements")
public void modifierPaiement(@RequestBody Paiement paie)
{
	paiementService.modif(paie);
}

//trouver le paiement par idPaie
@GetMapping("/paiements/{idPaie}")
public Paiement selectByIdpaie(@PathVariable("idPaie") int idPaie)
{
	Paiement paiement =paiementService.recupererParId(idPaie);
	
	return paiement;
}

//suppression
@DeleteMapping("/paiements/{idPaie}")
public void deletePaiement(@PathVariable("idPaie") int idPaie)
{
	paiementService.suppression(idPaie);
}

@GetMapping("/paiements/{idPaie}/formation")
public Formation trouverFormationParIdPaiement(@PathVariable("idPaie") int idPaie) {
  return paiementService.trouverFormationParIdPaiement(idPaie);
}

}
