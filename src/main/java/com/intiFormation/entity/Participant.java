package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("P")
public class Participant extends Utilisateur {


	@OneToMany(mappedBy = "participant")
	@JsonIgnore
	private List<Paiement> paiements;

	@ManyToMany
	@JoinTable(name = "tabPartFormation", joinColumns = @JoinColumn(name = "idParticipant"), inverseJoinColumns = @JoinColumn(name = "idFormation"))
	private List<Formation> formations;

	public Participant() {
		super();
	}


//	public int getIdPart() {
//		return idPart;
//	}
//
//	public void setIdPart(int idPart) {
//		this.idPart = idPart;
//	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

}
