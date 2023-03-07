// Déclaration du nom du package et importation des classes nécessaires
package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.service.IRoleService;

// Déclaration d'une classe de contrôleur pour l'entité Role
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/roles")
public class RoleController {

	// Injection de dépendances du RoleService pour effectuer les opérations liées à l'entité Role
	@Autowired
	private IRoleService roleService;

	// Méthode pour récupérer toutes les entités Role
	@GetMapping("/")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

	// Méthode pour récupérer une entité Role par son id
	@GetMapping("/{id}")
	public Optional<Role> getRoleById(@PathVariable int id) {
		return roleService.selectById(id);
	}
}
