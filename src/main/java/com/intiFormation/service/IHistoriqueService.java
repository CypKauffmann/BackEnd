package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Historique;

public interface IHistoriqueService {
	
	public void ajoutHist(Historique hist);
	public void supprimeHist(int id);
	public List<Historique> selectAll();
	public Historique selectById(int id);
	public List<Historique> selectHistByIdComm(int id);
	public List<Historique> selectHistByIdPers(int id);

}
