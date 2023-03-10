package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.FormateurDao;
import com.intiFormation.entity.Formateur;

@Service
public class FormateurService implements IFormateurService{
	
	@Autowired
	private FormateurDao formateurdao;
	

	
		public Formateur ajout(Formateur paiement)
		{
			return formateurdao.save(paiement);
		}

		//modification
		public void modif(Formateur formateur)
		{
			formateurdao.save(formateur);
		}
		
		//supprimer
		public void suppression(int idFormateur)
		{
			formateurdao.deleteById(idFormateur);
		}
		
		//afficher tous 
		public List<Formateur> selectAllFormateur()
		{
			return formateurdao.findAll();
		}
		
		//chercher un
		public Optional<Formateur> chercherParidFormateur(int idFormateur)
		{
			Optional<Formateur> opt =formateurdao.findById(idFormateur);
			return opt;
		}
		
		
		public Formateur recupererParId(int idFormateur)
		{
			return formateurdao.findById(idFormateur).get();
		}
		
		public List<Formateur> getFormateursWithFormations() {
	        return formateurdao.findAllWithFormations();
	    }

		
	}


