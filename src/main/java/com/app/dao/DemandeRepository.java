package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Demande;
import com.app.entity.Status;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
	
	public List<Demande> findDemandeByUserId(Long id);

	@Query("select d from Demande d where d.status = ?1")
	public List<Demande> findDemandesWithStatus(Status status);
}
