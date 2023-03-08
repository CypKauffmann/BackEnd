package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.CommercialDao;
import com.intiFormation.entity.Commercial;

@Service
public class CommercialService implements ICommercialService {
	
	@Autowired
	private CommercialDao commercialdao ;
	
	
	public void ajoutCom(Commercial comm)
	{
		commercialdao.save(comm) ;
	}
	
	public void supprimeCom(int id)
	{
		commercialdao.deleteById(id);
	}
	
	public List<Commercial> selectAll()
	{
		return commercialdao.findAll() ;
	}
	
	public Commercial selectById(int id)
	{
		return commercialdao.findById(id).get() ;
	}
	
	//find by id rdv
	public Commercial selectCommByIdRdvC(int id)
	{
		return commercialdao.findByRendezVousC_idRdv(id) ;
	}
	
	//find by id historique
	public Commercial selectCommByIdHistC(int id)
	{
		return commercialdao.findByHistoriquesC_idHist(id) ;
	}

}
