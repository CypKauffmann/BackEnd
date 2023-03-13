package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

@Service
public class CustemUserDetailService implements UserDetailsService {

	@Autowired
	private IUtilisateurservice utilisateurService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    
	    // Cherche l'utilisateur correspondant au nom d'utilisateur fourni
	    Utilisateur utilisateur = utilisateurService.chercherParUsername(username);
	    
	    // Si l'utilisateur n'existe pas, lance une exception UsernameNotFoundException
	    if (utilisateur == null) {
	        throw new UsernameNotFoundException(username);
	    }
	    
	    // Obtient le rôle de l'utilisateur
	    Role role = utilisateur.getRole();
	    
	    // Crée une liste de rôles (GrantedAuthority) pour l'utilisateur
	    List<GrantedAuthority> listeRole = new ArrayList<>();
	    
	    // Crée un objet GrantedAuthority à partir du nom de rôle et l'ajoute à la liste de rôles
	    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getNomRole());
	    listeRole.add(grantedAuthority);
	    
	    // Crée et retourne un objet UserDetails contenant les informations de l'utilisateur
	    UserDetails user = new User(utilisateur.getUsername(), utilisateur.getPassword(), listeRole);
	    return user;
	}

	
	
}
