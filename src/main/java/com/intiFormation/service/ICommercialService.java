package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Commercial;

public interface ICommercialService {
	
	public void ajoutCom(Commercial comm);
	public void supprimeCom(int id);
	public List<Commercial> selectAll();
	public Commercial selectById(int id);
	public Commercial selectCommByIdRdv(int id);
	public Commercial selectCommByIdHist(int id);

}
