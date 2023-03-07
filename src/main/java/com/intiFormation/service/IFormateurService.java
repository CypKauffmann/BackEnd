package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Formateur;

public interface IFormateurService {


	public Formateur ajout(Formateur paiement);
	
	//modification
	public void modif(Formateur formateur);

	
	//supprimer
	public void suppression(int idFormateur);
	
	//afficher tous 
	public List<Formateur> selectAllFormateur();
	
	
	//chercher un
	public Optional<Formateur> chercherParidFormateur(int idFormateur);
	
	
	public Formateur recupererParId(int idFormateur);
	
}
