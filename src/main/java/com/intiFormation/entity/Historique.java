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

@Entity
public class Historique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHist;
	@Temporal(TemporalType.DATE)
	private Date dateHist;
	private String commentaire;

	@ManyToOne
	@JoinColumn(name = "idCommercial")
	private Commercial commercial;

	@ManyToOne
	@JoinColumn(name = "idPersonne")
	private Personne personne;

	public Historique() {

	}

	public Historique(Date dateHist, String commentaire) {
		this.dateHist = dateHist;
		this.commentaire = commentaire;
	}

	public int getIdHist() {
		return idHist;
	}

	public void setIdHist(int idHist) {
		this.idHist = idHist;
	}

	public Date getDateHist() {
		return dateHist;
	}

	public void setDateHist(Date dateHist) {
		this.dateHist = dateHist;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Commercial getCommercial() {
		return commercial;
	}

	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Historique [idHist=" + idHist + ", dateHist=" + dateHist + ", commentaire=" + commentaire + "]";
	}

}
