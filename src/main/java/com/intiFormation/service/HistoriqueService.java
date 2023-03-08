package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.HistoriqueDao;
import com.intiFormation.entity.Historique;

@Service
public class HistoriqueService implements IHistoriqueService {
	
	@Autowired
	private HistoriqueDao historiquedao ;
	
	
	
	public void ajoutHist(Historique hist)
	{
		historiquedao.save(hist) ;
	}
	
	public void supprimeHist(int id)
	{
		historiquedao.deleteById(id) ;
	}
	
	public List<Historique> selectAll()
	{
		return historiquedao.findAll() ;
	}
	
	public Historique selectById(int id)
	{
		return historiquedao.findById(id).get() ;
	}
	
<<<<<<< HEAD
=======
	
	
>>>>>>> main
	//find by id personne
	public List<Historique> selectHistByIdPers(int id)
	{
		return historiquedao.findByPersonne_idPers(id) ;
	}

}
