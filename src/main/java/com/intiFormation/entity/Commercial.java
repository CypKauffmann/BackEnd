package com.intiFormation.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("C")
public class Commercial extends Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComm;

	@OneToMany(mappedBy = "commercial")
	private List<RendezVous> rendezVous;

	@OneToMany(mappedBy = "commercial")
	private List<Historique> historiques;

	public int getIdComm() {
		return idComm;
	}

	public void setIdComm(int idComm) {
		this.idComm = idComm;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Commercial(int idComm, List<RendezVous> rendezVous, List<Historique> historiques) {
		super();
		this.idComm = idComm;
		this.rendezVous = rendezVous;
		this.historiques = historiques;
	}

	public Commercial() {
		super();
	}

	

}
