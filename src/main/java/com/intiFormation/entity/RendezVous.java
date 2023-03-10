package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRdv;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, locale = "fr_FR", timezone = "Europe/Amsterdam")
	private Date dateRdv;

	@ManyToOne
	@JoinColumn(name = "idPersonne")
	private Personne personne;

	@ManyToOne
	@JoinColumn(name = "idCommercial")
	private Commercial commercial;

	public RendezVous() {

	}

	public RendezVous(int idRdv, Date dateRdv, Personne personne, Commercial commercial) {
		super();
		this.idRdv = idRdv;
		this.dateRdv = dateRdv;
		this.personne = personne;
		this.commercial = commercial;
	}

	public int getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Commercial getCommercial() {
		return commercial;
	}

	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}

	@Override
	public String toString() {
		return "RendezVous [idRdv=" + idRdv + ", dateRdv=" + dateRdv + "]";
	}

}