package com.intiFormation.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paiement {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaie ;
    private int aRembourser ;
    private int dejaRegler ;
    private int montantTot ;
    private String typePaiement ;
    @Temporal(TemporalType.DATE)
    private Date datePaiement ;

    private Formation formation ;

    @ManyToOne
    @JoinColumn(name="idParticipant")
    private Participant participant ;

    
    
	public Paiement() {
		super();
	}

	public Paiement(int aRembourser, int dejaRegler, int montantTot, String typePaiement, Date datePaiement) {
		super();
		this.aRembourser = aRembourser;
		this.dejaRegler = dejaRegler;
		this.montantTot = montantTot;
		this.typePaiement = typePaiement;
		this.datePaiement = datePaiement;
	}

	
	
	public int getIdPaie() {
		return idPaie;
	}

	public void setIdPaie(int idPaie) {
		this.idPaie = idPaie;
	}

	public int getaRembourser() {
		return aRembourser;
	}

	public void setaRembourser(int aRembourser) {
		this.aRembourser = aRembourser;
	}

	public int getDejaRegler() {
		return dejaRegler;
	}

	public void setDejaRegler(int dejaRegler) {
		this.dejaRegler = dejaRegler;
	}

	public int getMontantTot() {
		return montantTot;
	}

	public void setMontantTot(int montantTot) {
		this.montantTot = montantTot;
	}

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	
	
	@Override
	public String toString() {
		return "Paiement [idPaie=" + idPaie + ", aRembourser=" + aRembourser + ", dejaRegler=" + dejaRegler
				+ ", montantTot=" + montantTot + ", typePaiement=" + typePaiement + ", datePaiement=" + datePaiement
				+ "]";
	}
    
    
    

}
