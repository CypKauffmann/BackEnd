package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("C")
public class Commercial extends Utilisateur {

	@OneToMany(mappedBy = "commercial")
	@JsonIgnore
	private List<RendezVous> rendezVousC;

	@OneToMany(mappedBy = "commercial")
	@JsonIgnore
	private List<Historique> historiquesC;

	public List<RendezVous> getRendezVousC() {
		return rendezVousC;
	}

	public void setRendezVousC(List<RendezVous> rendezVousC) {
		this.rendezVousC = rendezVousC;
	}

	public List<Historique> getHistoriquesC() {
		return historiquesC;
	}

	public void setHistoriquesC(List<Historique> historiquesC) {
		this.historiquesC = historiquesC;
	}

	public Commercial() {
		super();
	}

}
