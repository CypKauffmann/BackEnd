package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.RendezVous;

public interface IRendezVousService {
	
	public void ajoutRdv(RendezVous rdv);
	public void supprimeRdv(int id);
	public List<RendezVous> selectAll();;
	public RendezVous selectById(int id);
	public List<RendezVous> selectRdvByIdComm(int id);
	public List<RendezVous> selectRdvByIdPers(int id);
}
