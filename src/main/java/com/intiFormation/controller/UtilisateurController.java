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

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IUtilisateurservice;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

	@Autowired
	private IUtilisateurservice utilisateurService;

	@GetMapping("/")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateur();
	}

	@GetMapping("/{id}")
	public Utilisateur getUtilisateurById(@PathVariable int id) {
		return utilisateurService.getUtilisateurById(id);
	}

	@GetMapping("/username/{username}")
	public Utilisateur getUtilisateurByUsername(@PathVariable String username) {
		return utilisateurService.getUtilisateurByUsername(username);
	}

	@PostMapping("/")
	public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
		System.out.println(utilisateur.getNomPers());
		utilisateurService.addUtilisateur(utilisateur);
	}

	@PutMapping("/")
	public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.updateParticipant(utilisateur);
	}

	@DeleteMapping("/{id}")
	public void deleteUtilisateur(@PathVariable int id) {
		utilisateurService.deleteutilisateur(id);
	}

	




}
