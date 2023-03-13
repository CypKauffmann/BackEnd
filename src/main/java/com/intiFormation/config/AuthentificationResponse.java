package com.intiFormation.config;

import org.springframework.web.bind.annotation.RequestMapping;

public class AuthentificationResponse {
	
	// token JWT généré lors de l'authentification réussie
	private  String jwt;

	// constructeur pour créer un objet AuthentificationResponse contenant le token JWT
	public AuthentificationResponse(String jwt) {
		this.jwt = jwt;
	}

	// accesseur pour récupérer le token JWT
	public String getJwt() {
		return jwt;
	}
	
	
public AuthentificationResponse() {
		
		super();
	}
	
	
	
	
	/* En résumé, cette classe représente la réponse retournée lors d'une authentification réussie.
	 * Elle contient un token JWT généré pour l'utilisateur authentifié. La classe a un constructeur qui prend en paramètre le token JWT et un accesseur qui permet de récupérer le token JWT. */
}

