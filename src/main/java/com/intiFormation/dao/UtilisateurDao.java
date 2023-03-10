package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.intiFormation.entity.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
	public Utilisateur findByUsername(String username);

	@Modifying
	@Query(value = "INSERT INTO participant (id_pers) VALUES (?1)", nativeQuery = true)
	void addParticipant(Long idPers);

	@Modifying
	@Query(value = "UPDATE utilisateur SET id_role = 3 WHERE id_pers = ?1", nativeQuery = true)
	void assignParticipantRole(Long idPers);


	@Modifying
	@Query(value = "INSERT INTO formateur (id_pers) VALUES (?1)", nativeQuery = true)
	void addFormateur(Long idPers);

	@Modifying
	@Query(value = "UPDATE utilisateur SET id_role = 2 WHERE id_pers = ?1", nativeQuery = true)
	void assignFormateurRole(Long idPers);


	@Modifying
	@Query(value = "INSERT INTO commercial (id_pers) VALUES (?1)", nativeQuery = true)
	void addCommercial(Long idPers);

	@Modifying
	@Query(value = "UPDATE utilisateur SET id_role = 1 WHERE id_pers = ?1", nativeQuery = true)
	void assignCommercialRole(Long idPers);


}
