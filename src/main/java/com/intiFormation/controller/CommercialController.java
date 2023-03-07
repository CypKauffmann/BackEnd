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

import com.intiFormation.entity.Commercial;
import com.intiFormation.service.ICommercialService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CommercialController {
	
	@Autowired
	private ICommercialService commercialservice ;
	
	
	
	@GetMapping("/commercials")
	public List<Commercial> afficherAll()
	{
		return commercialservice.selectAll() ;
	}
	
	@GetMapping("/commercials/{id}")
	public Commercial afficherById(@PathVariable("id") int id)
	{
		return commercialservice.selectById(id) ;
	}
	
	@GetMapping("/commercialsByHist/{id}")
	public Commercial afficherByIdHist(@PathVariable("id") int id)
	{
		return commercialservice.selectCommByIdHist(id) ;
	}
	
	@GetMapping("/commercialsByRdv/{id}")
	public Commercial afficherByIdRdv(@PathVariable("id") int id)
	{
		return commercialservice.selectCommByIdRdv(id) ;
	}
	
	@PostMapping("/commercials")
	public void ajouter(@RequestBody Commercial comm)
	{
		commercialservice.ajoutCom(comm) ;
	}
	
	@DeleteMapping("/commercials/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		commercialservice.supprimeCom(id) ;
	}
	
	@PutMapping("/commercials")
	public void modifier(@RequestBody Commercial comm)
	{
		commercialservice.ajoutCom(comm) ;
	}

}
