package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.RoleDao;
import com.intiFormation.entity.Role;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleDao roleDao;


	// Méthode pour récupérer une entité Role par son id
	public Optional<Role> selectById(int id) {
		// Appel de la méthode findById du RoleDao et retour de l'objet Optional résultant
		Optional<Role> opRole = roleDao.findById(id);
		return opRole;
	}

	// Méthode pour récupérer toutes les entités Role
	public List<Role> getAllRoles() {
		// Appel de la méthode findAll du RoleDao et retour de l'objet List résultant
		return roleDao.findAll();
	}

}
