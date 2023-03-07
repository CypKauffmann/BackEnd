package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurservice {
	public void addUtilisateur(Utilisateur utilisateur);
	public void deleteutilisateur(int id);
	public void updateParticipant(Utilisateur utilisateur);
	public List<Utilisateur> getAllUtilisateur();
	public Utilisateur getUtilisateurByUsername(String username);
	public Utilisateur getUtilisateurById(int id);
	
	
}
