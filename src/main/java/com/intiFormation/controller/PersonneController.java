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

import com.intiFormation.entity.Personne;
import com.intiFormation.service.IPersonneService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PersonneController {
	
	@Autowired
	private IPersonneService personneservice ;
	
	
	@GetMapping("/personnes")
	public List<Personne> afficherAll()
	{
		return personneservice.selectAll() ;
	}
	
	@GetMapping("/personnes/{id}")
	public Personne afficherById(@PathVariable("id") int id)
	{
		return personneservice.selectById(id) ;
	}
	
	@GetMapping("/personnesByHist/{id}")
	public Personne afficherByIdHist(@PathVariable("id") int id)
	{
		return personneservice.selectPersByIdHist(id) ;
	}
	
	@GetMapping("/personnesByRdv/{id}")
	public Personne afficherByIdRdv(@PathVariable("id") int id)
	{
		return personneservice.selectPersByIdRdv(id) ;
	}
	
	@PostMapping("/personnes")
	public void ajouter(@RequestBody Personne pers)
	{
		personneservice.ajoutPers(pers) ;
	}
	
	@DeleteMapping("/personnes/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		personneservice.supprimePers(id) ;
	}
	
	
	@PutMapping("/personnes/{idPers}")
	public ResponseEntity<Personne> modifier(@PathVariable("idPers") int idPers, @RequestBody Personne personne) {
	    Personne pers = personneservice.selectById(idPers);
	    if (pers == null) {
	        return ResponseEntity.notFound().build();
	    }
	    pers.setIdPers(personne.getIdPers());
	    pers.setNomPers(personne.getNomPers());
	    pers.setPrenomPers(personne.getPrenomPers());
	    pers.setAge(personne.getAge());
	    pers.setEmail(personne.getEmail());
	    pers.setTel(personne.getTel());
	    
	    personneservice.ajoutPers(pers);
	    return ResponseEntity.ok(pers);
	}
}
