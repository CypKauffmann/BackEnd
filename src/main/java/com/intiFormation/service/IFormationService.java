package com.intiFormation.service;

import java.util.List;

import java.util.Optional;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;

public interface IFormationService {
	
	public Formation ajout(Formation formation);
	
	public void modif(Formation formation);
	
	public void suppression(int idForm);
	
	public List<Formation> selectAllFormation();
	
	public Optional<Formation> chercherParIdidForm (int idForm);
	
	public Formation recupererParId(int id);

	public List<Formation> getAllFormationsWithPaiements() ;
	public List<Paiement> getPaiementsByFormation(int idFormation);
	
 public List<Formation> getAllFormationsWithParticipantsAndFormateurs() ;

}
