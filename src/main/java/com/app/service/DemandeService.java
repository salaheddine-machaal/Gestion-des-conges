package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.dao.AppUserRepository;
import com.app.dao.DemandeRepository;
import com.app.entity.AppRole;
import com.app.entity.AppUser;
import com.app.entity.Demande;
import com.app.entity.Roles;
import com.app.entity.Status;

@Service
public class DemandeService implements IDemandeService {

	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private IAppUserService userService;
	
	@Override
	public List<Demande> getDemandes(Long id){
		AppUser user = userRepository.findById(id).orElse(null);
		if(user == null) return null;
		AppRole dgRole = user.getRoles().stream().filter(r -> Roles.DG.equals(r.getRolename())).findFirst().orElse(null);
		AppRole rhRole = user.getRoles().stream().filter(r -> Roles.RH.equals(r.getRolename())).findFirst().orElse(null);
		AppRole managerRole = user.getRoles().stream().filter(r -> Roles.MANAGER.equals(r.getRolename())).findFirst().orElse(null);
		AppRole employeeRole = user.getRoles().stream().filter(r -> Roles.EMPLOYEE.equals(r.getRolename())).findFirst().orElse(null);
		
		if(dgRole != null) {
			return demandeRepository.findDemandesWithStatus(Status.VALIDATED);
		}
		
		if(rhRole != null) {
			return demandeRepository.findDemandesWithStatus(Status.ACCEPTED);
		}
		
		if(managerRole != null) {
			List<AppUser> users = userService.getSubordinatesByManagerId(user.getId());
			List<Demande> demandes = new ArrayList<Demande>();
			for(AppUser u : users) {
				demandes.addAll(demandeRepository.findDemandeByUserId(u.getId()));
			}
			return demandes;
		}
		
		if(employeeRole != null) {
			return demandeRepository.findDemandeByUserId(user.getId());
		}
		return null;
	}

	@Override
	public Demande createDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public void deleteDemande(Long id) {
		demandeRepository.deleteById(id);
	}

	@Override
	public Demande setStatus(Demande demande) {
		//
		return demandeRepository.save(demande);
	}
	
	private Collection<? extends GrantedAuthority> getUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    return authentication.getAuthorities();
		}
		return null;
	}
	
}
