package com.intiFormation.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RendezVous {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRdv;
    private Date dateRdv;
    @ManyToOne
    @JoinColumn(name = "id_rdv")
    private Personne persone;
    
    @ManyToOne
    @JoinColumn(name = "id_commercial")
    private Commercial commercial;

    
	public RendezVous() 
	{

	}
	
	public RendezVous(int idRdv, Date dateRdv, Personne persone, Commercial commercial) {
		super();
		this.idRdv = idRdv;
		this.dateRdv = dateRdv;
		this.persone = persone;
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


	public Personne getPersone() {
		return persone;
	}

	public void setPersone(Personne persone) {
		this.persone = persone;
	}

	public Commercial getCommercial() {
		return commercial;
	}

	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}


}
