package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Demande;
import com.app.service.IDemandeService;

@RestController
public class DemandeController {

	@Autowired
	private IDemandeService demandeService;
	
	@GetMapping("/demandes")
	public List<Demande> getDemandes(@RequestParam Long id){
		return demandeService.getDemandes(id);
	}
	
	@PostMapping("/demande")
	public Demande createDemande(@RequestBody Demande demande) {
		return demandeService.createDemande(demande);
	}
	
	@PutMapping("/demande")
	public Demande changeStatusDemande(@RequestBody Demande demande) {
		return demandeService.setStatus(demande);
	}
	
	@DeleteMapping("/demande")
	public void deleteDemande(@RequestParam Long id) {
		demandeService.deleteDemande(id);
	}
 	
}
