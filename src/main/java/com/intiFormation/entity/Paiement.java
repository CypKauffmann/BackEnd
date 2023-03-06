package com.intiFormation.entity;

import java.sql.Date;

@Entity
public class Paiement {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaie ;
    private int aRembourser ;
    private int dejaRegler ;
    private int montantTot ;
    private String typePaiement ; 
    private Date datePaiement ;

    private Formation formation ;

    private Participant participant ;

}
