package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Utilisateur {



	@ManyToMany
	@JoinTable(name = "tabFormateurFormation", joinColumns = @JoinColumn(name = "idFormateur"), inverseJoinColumns = @JoinColumn(name = "idFormation"))
	private List<Formation> formations;



	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}


	public Formateur() {
		super();
	}

	
}
