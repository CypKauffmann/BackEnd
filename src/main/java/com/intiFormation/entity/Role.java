package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String nomRole;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private List<Utilisateur> utilisateurs;

	
    public Role(int idRole, String nomRole, List<Utilisateur> utilisateurs) {
		super();
		this.idRole = idRole;
		this.nomRole = nomRole;
		this.utilisateurs = utilisateurs;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdRole() {
		return idRole;
	}


	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	public String getNomRole() {
		return nomRole;
	}


	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
    
	
    

}