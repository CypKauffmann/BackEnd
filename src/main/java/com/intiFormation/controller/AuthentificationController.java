package com.intiFormation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.config.AuthentificationRequest;
import com.intiFormation.config.AuthentificationResponse;
import com.intiFormation.config.jwtUtil;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class AuthentificationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService custemUserDetailsService;

	@Autowired
	private jwtUtil jwtokenUtil;

	@PostMapping("/loginUserJwt")
	public AuthentificationResponse authenticate(@RequestBody AuthentificationRequest authentificationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authentificationRequest.getUsername(), authentificationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username ou password", e);
		}

		// récupérer les informations sur l'utilisateur authentifié à partir de la couche de service de sécurité (UserDetailsService)
		final UserDetails userdetails = custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		// générer un token JWT pour l'utilisateur authentifié à partir de la classe jwtUtil
		final String jwt = jwtokenUtil.generateToken(userdetails);

		// retourner l'objet AuthentificationResponse qui contient le token JWT
		return new AuthentificationResponse(jwt);
	}
	
	
	
	/*En résumé, cette classe représente un contrôleur REST pour l'authentification des utilisateurs.
	  Elle contient une méthode authenticate qui permet à un utilisateur de s'authentifier en envoyant une demande d'authentification contenant le nom d'utilisateur et le mot de passe.
	  La méthode utilise un AuthenticationManager pour valider les informations d'identification de l'utilisateur et récupère les informations de l'utilisateur authentifié à partir d'un UserDetailsService.
	  La méthode utilise également la classe jwtUtil pour générer un token JWT pour l'utilisateur authentifié. Elle retourne un objet AuthentificationResponse contenant le token JWT généré.*/
}
