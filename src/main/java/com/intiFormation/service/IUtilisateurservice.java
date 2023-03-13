package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurservice {
	
	public void deleteutilisateur(int id);
	
	
	void addUtilisateur(Utilisateur utilisateur);


	void updateParticipant(Utilisateur utilisateur);

	List<Utilisateur> getAllUtilisateur();

	Utilisateur getUtilisateurByUsername(String username);

	Utilisateur getUtilisateurById(int id);

	public void assignParticipant(Long idPers);

	public void assignFormateur(Long idPers);

	public void assignCommercial(Long idPers);
	public Utilisateur chercherParUsername(String username) ;
	public boolean verifierUsername(Utilisateur u);
}
