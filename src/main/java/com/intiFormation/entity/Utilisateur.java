package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUt;
	private String username;
	private String password;

	@OneToMany
	@JoinColumn(name = "idRole")
	private Role role;

	public int getIdUt() {
		return idUt;
	}

	public void setIdUt(int idUt) {
		this.idUt = idUt;
	}

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
			List<RendezVous> rendezVous, List<Historique> historiques, int idUt, String username, String password,
			Role role) {
		super(idPers, nomPers, prenomPers, age, email, tel, rendezVous, historiques);
		this.idUt = idUt;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Utilisateur [idUt=" + idUt + ", username=" + username + ", password=" + password + "]";
	}

}
