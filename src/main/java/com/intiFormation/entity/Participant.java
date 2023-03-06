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
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("P")
public class Participant extends Utilisateur {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPart;

	@OneToMany(mappedBy = "participant")
	private List<Paiement> paiements;

	@ManyToMany
	@JoinTable(name = "tabPartFormation", joinColumns = @JoinColumn(name = "idParticipant"), inverseJoinColumns = @JoinColumn(name = "idFormation"))
	private List<Formation> formations;

	public Participant() {
		super();
	}

	public Participant(int idPart) {
		super();
		this.idPart = idPart;
	}

	@Override
	public String toString() {
		return "Participant [idPart=" + idPart + "]";
	}

	public int getIdPart() {
		return idPart;
	}

	public void setIdPart(int idPart) {
		this.idPart = idPart;
	}

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
