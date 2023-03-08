package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.RendezVousDao;
import com.intiFormation.entity.RendezVous;

@Service
public class RendezVousService implements IRendezVousService {
	
	@Autowired
	private RendezVousDao rdvdao ;
	
	
	
	public void ajoutRdv(RendezVous rdv)
	{
		rdvdao.save(rdv) ;
	}
	
	public void supprimeRdv(int id)
	{
		rdvdao.deleteById(id) ;
	}
	
	public List<RendezVous> selectAll()
	{
		return rdvdao.findAll() ;
	}
	
	public RendezVous selectById(int id)
	{
		return rdvdao.findById(id).get() ;
	}
	
	//find by id personne
	public List<RendezVous> selectRdvByIdPers(int id)
	{
		return rdvdao.findByPersonne_idPers(id) ;
	}

}
