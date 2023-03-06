package com.intiFormation.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Commercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComm;
	
	@OneToMany(mappedBy = "commercial")
	private List<RendezVous> RendezVous ;

	
	
	
	
	
	
}
