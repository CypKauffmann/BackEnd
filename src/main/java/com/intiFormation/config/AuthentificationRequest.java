package com.intiFormation.config;

public class AuthentificationRequest {
	
	// nom d'utilisateur de l'utilisateur qui souhaite s'authentifier
	private String username;
	
	// mot de passe de l'utilisateur qui souhaite s'authentifier
	private String password;
	
	
	// constructeur pour créer un objet AuthentificationRequest contenant le nom d'utilisateur et le mot de passe
	public AuthentificationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// constructeur par défaut
	public AuthentificationRequest() {
		super();
	}
	
	// accesseur pour récupérer le nom d'utilisateur
	public String getUsername() {
		return username;
	}
	
	// mutateur pour définir le nom d'utilisateur
	public void setUsername(String username) {
		this.username = username;
	}
	
	// accesseur pour récupérer le mot de passe
	public String getPassword() {
		return password;
	}
	
	// mutateur pour définir le mot de passe
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/* En résumé, cette classe représente une demande d'authentification. Elle contient le nom d'utilisateur et le mot de passe de l'utilisateur qui souhaite s'authentifier.
	   La classe a un constructeur qui prend en paramètre le nom d'utilisateur et le mot de passe, et des accesseurs/mutateurs pour accéder aux propriétés. */
}




