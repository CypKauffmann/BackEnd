package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intiFormation.entity.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
	public Utilisateur findByUsername(String username);

	
}
