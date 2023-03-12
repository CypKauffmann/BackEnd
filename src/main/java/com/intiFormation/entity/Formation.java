package com.intiFormation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idForm;
	private String nomForm;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private double prix;
	private int duree;

	@ManyToMany(mappedBy = "formations")
    @JsonIgnoreProperties("formations")
	private List<Formateur> formateurs;

	@ManyToMany(mappedBy = "formations")
    @JsonIgnoreProperties("formations")
	private List<Participant> participants;

	@ManyToMany(mappedBy = "formations")
	@JsonIgnore
	private List<Paiement> paiements;

	public Integer getIdForm() {
		return idForm;
	}


	public void setIdForm(Integer idForm) {
		this.idForm = idForm;
	}


	public String getNomForm() {
		return nomForm;
	}

	public void setNomForm(String nomForm) {
		this.nomForm = nomForm;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public Formation(Integer idForm, String nomForm, Date dateDebut, Date dateFin, double prix, int duree,
			List<Formateur> formateurs, List<Participant> participants, List<Paiement> paiements) {
		super();
		this.idForm = idForm;
		this.nomForm = nomForm;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.duree = duree;
		this.formateurs = formateurs;
		this.participants = participants;
		this.paiements = paiements;
	}

	public Formation() {
		super();
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
