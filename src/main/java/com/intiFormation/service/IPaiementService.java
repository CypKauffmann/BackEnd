package com.intiFormation.service;
import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;

public interface IPaiementService {
	
	//ajout
	public Paiement ajout(Paiement paiement);
	
	//modif
	public void modif(Paiement paiement);
	
	//suppression
	public void suppression(int idPaie);
	
	//afficher tous les paiements
	public List<Paiement> selectAllPaiement();
	
	//chercher un paiement par id
	public Optional<Paiement> chercherParIdPaie(int idPaie);
	
	public Paiement recupererParId(int id);
		
	//valider un paiement
	public void validerPaiement(int idPaie);
	
	public Formation trouverFormationParIdPaiement(int idPaie);
}
