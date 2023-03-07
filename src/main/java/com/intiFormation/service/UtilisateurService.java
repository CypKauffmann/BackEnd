package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.UtilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurservice {

	@Autowired
	private UtilisateurDao utilisateurDao;

	public void addUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
	}

	public void deleteutilisateur(int id) {
		utilisateurDao.deleteById(id);
	}

	public void updateParticipant(Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
	}

	public List<Utilisateur> getAllUtilisateur() {
		return utilisateurDao.findAll();
	}

	public Utilisateur getUtilisateurByUsername(String username) {
		return utilisateurDao.findByUsername(username);
	}

	public Utilisateur getUtilisateurById(int id) {
		java.util.Optional<Utilisateur> utilisateur = utilisateurDao.findById(id);
		if (utilisateur.isPresent()) {
			return utilisateur.get();
		} else {
			throw new RuntimeException("Utilisateur non trouvé pour l'id :: " + id);
		}
	}

}
