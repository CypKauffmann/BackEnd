package com.intiFormation.entity;

import java.sql.Date;
import java.util.List;



@Entity
public class Historique {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHist ;
    private Date dateHist ;
    private String commentaire ;

    @ManyToOne
    @JointColumn(name="idCommercial")
    private Commercial commercial ;

    @ManyToOne
    @JointColumn(name="idPersonne")
    private Personne personnes ;


    public Historique()
    {

    }

    public Historique(Date dateHist, String commentaire)
    {
        this.dateHist = dateHist ;
        this.commentaire = commentaire ;
    }



}
