package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.PersonneDao;
import com.intiFormation.entity.Personne;

@Service
public class PersonneService implements IPersonneService {
	
	@Autowired
	private PersonneDao personnedao ;
	
	
	
	public void ajoutPers(Personne pers)
	{
		personnedao.save(pers) ;
	}
	
	public void supprimePers(int id)
	{
		personnedao.deleteById(id) ;
	}
	
	public List<Personne> selectAll()
	{
		return personnedao.findAll() ;
	}
	
	public Personne selectById(int id)
	{
		return personnedao.findById(id).get() ;
	}
	
	//find by id historique
	public Personne selectPersByIdHist(int id)
	{
		return personnedao.findByHistoriques_idHist(id) ;
	}
	
	//find by id rdv
	public Personne selectPersByIdRdv(int id)
	{
		return personnedao.findByRendezVous_idRdv(id) ;
	}

}
