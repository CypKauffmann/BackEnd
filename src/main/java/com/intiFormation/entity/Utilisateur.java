package com.intiFormation.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Utilisateur extends Personne {

	private String username;
	private String password;

	@ManyToOne
	@JoinColumn(name = "idRole")
	private Role role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Utilisateur(int idPers, String nomPers, String prenomPers, int age, String email, String tel,
			List<RendezVous> rendezVous, List<Historique> historiques, String username, String password, Role role) {
		super(idPers, nomPers, prenomPers, age, email, tel, rendezVous, historiques);
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Utilisateur() {
		super();
	}


	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", password=" + password + "]";
	}

}
