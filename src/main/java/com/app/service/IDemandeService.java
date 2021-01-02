package com.app.service;

import java.util.List;

import com.app.entity.AppUser;
import com.app.entity.Demande;

public interface IDemandeService {

	List<Demande> getDemandes(Long id);
	
	Demande createDemande(Demande demande);
	
	void deleteDemande(Long id);
	
	Demande setStatus(Demande demande);
	
}
