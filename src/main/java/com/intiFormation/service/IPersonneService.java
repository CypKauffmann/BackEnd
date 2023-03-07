package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Personne;

public interface IPersonneService {
	
	public void ajoutPers(Personne pers);
	public void supprimePers(int id);
	public List<Personne> selectAll();
	public Personne selectById(int id);
	public Personne selectPersByIdHist(int id);
	public Personne selectPersByIdRdv(int id);

}
