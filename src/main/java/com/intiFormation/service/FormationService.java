package com.intiFormation.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.FormationDao;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;

@Service
public class FormationService implements IFormationService{

	
	@Autowired
	private FormationDao formatiodao;
	

	//ajout d'un paiement
	public Formation ajout(Formation formation)
	{
		return formatiodao.save(formation);
	}

	//modification
	public void modif(Formation formation)
	{
		formatiodao.save(formation);
	}
	
	//supprimer
	public void suppression(int idForm)
	{
		formatiodao.deleteById(idForm);
	}
	
	//afficher tous les paiements
	public List<Formation> selectAllFormation()
	{
		return formatiodao.findAll();
	}
	
	//chercher un paiement
	public Optional<Formation> chercherParIdidForm (int idForm)
	{
		Optional<Formation> opt =formatiodao.findById(idForm);
		return opt;
	}
	
	//paiement par id
	public Formation recupererParId(int id)
	{
		return formatiodao.findById(id).get();
	}
	
	public List<Formation> getAllFormationsWithPaiements() {
        List<Formation> formations = formatiodao.findAll();
        for (Formation formation : formations) {
            List<Paiement> paiements = formation.getPaiements();
            paiements.size(); // Force le chargement des paiements depuis la base de données
        }
        return formations;
    }
	
	public List<Paiement> getPaiementsByFormation(int idFormation) {
	    Formation formation = formatiodao.findById(idFormation).orElse(null);
	    if (formation != null) {
	        return formation.getPaiements();
	    }
	    return null;
	}
}
