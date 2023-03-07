package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.PaiementDao;
import com.intiFormation.entity.Paiement;

@Service
public class PaiementService implements IPaiementService{
	
	@Autowired
	private PaiementDao paiementdao;
	
	//ajout d'un paiement
	public Paiement ajout(Paiement paiement)
	{
		return paiementdao.save(paiement);
	}

	//modification
	public void modif(Paiement paiement)
	{
		paiementdao.save(paiement);
	}
	
	//supprimer
	public void suppression(int idPaie)
	{
		paiementdao.deleteById(idPaie);
	}
	
	//afficher tous les paiements
	public List<Paiement> selectAllPaiement()
	{
		return paiementdao.findAll();
	}
	
	//chercher un paiement
	public Optional<Paiement> chercherParIdPaie(int idPaie)
	{
		Optional<Paiement> opt =paiementdao.findById(idPaie);
		return opt;
	}
	
	//paiement par id
	public Paiement recupererParId(int id)
	{
		return paiementdao.findById(id).get();
	}
	
	//valider un paiement
	public void validerPaiement(int idPaie)
	{
		paiementdao.findById(idPaie);
	}
}
