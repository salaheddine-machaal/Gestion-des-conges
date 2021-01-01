package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRolename(String rolename);
	
}
