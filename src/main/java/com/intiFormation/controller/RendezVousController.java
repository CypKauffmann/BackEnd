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

import com.intiFormation.entity.RendezVous;
import com.intiFormation.service.IRendezVousService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RendezVousController {
	
	@Autowired
	private IRendezVousService rdvservice ;
	
	
	
	@GetMapping("/rendezvous")
	public List<RendezVous> afficherAll()
	{
		return rdvservice.selectAll() ;
	}
	
	@GetMapping("/rendezvous/{id}")
	public RendezVous afficherById(@PathVariable("id") int id)
	{
		return rdvservice.selectById(id) ;
	}
	
<<<<<<< HEAD
=======
	
	
>>>>>>> main
	@GetMapping("/rendezvousByPers/{id}")
	public List<RendezVous> afficherByIdPers(@PathVariable("id") int id)
	{
		return rdvservice.selectRdvByIdPers(id) ;
	}
	
	@PostMapping("/rendezvous")
	public void ajouter(@RequestBody RendezVous rdv)
	{
		rdvservice.ajoutRdv(rdv) ;
	}
	
	@DeleteMapping("/rendezvous/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		rdvservice.supprimeRdv(id) ;
	}
	
	@PutMapping("/rendezvous")
	public void modifier(@RequestBody RendezVous rdv)
	{
		rdvservice.ajoutRdv(rdv) ;
	}

}
