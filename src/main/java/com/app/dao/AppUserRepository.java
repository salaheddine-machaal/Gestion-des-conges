package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	public AppUser findByUsername(String username);
	
	public List<AppUser> findByManagerId(Long id);
}
