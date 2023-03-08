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

import com.intiFormation.entity.Historique;
import com.intiFormation.service.IHistoriqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class HistoriqueController {
	
	@Autowired
	private IHistoriqueService histservice ;
	
	
	@GetMapping("/historiques")
	public List<Historique> afficherAll()
	{
		return histservice.selectAll() ;
	}
	
	@GetMapping("/historiques/{id}")
	public Historique afficherById(@PathVariable("id") int id)
	{
		return histservice.selectById(id) ;
	}
	
<<<<<<< HEAD
=======
	
>>>>>>> main
	
	@GetMapping("/historiquesByPers/{id}")
	public List<Historique> afficherByIdPers(@PathVariable("id") int id)
	{
		return histservice.selectHistByIdPers(id) ;
	}
	
	@PostMapping("/historiques")
	public void ajouter(@RequestBody Historique hist)
	{
		histservice.ajoutHist(hist) ;
	}
	
	@DeleteMapping("/historiques/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		histservice.supprimeHist(id) ;
	}
	
	@PutMapping("/historiques")
	public void modifier(@RequestBody Historique hist)
	{
		histservice.ajoutHist(hist) ;
	}

}
