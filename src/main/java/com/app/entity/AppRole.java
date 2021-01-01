package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppRole {

	@Id @GeneratedValue
	private Long id;
	private String rolename;
	
	public AppRole() {
		super();
	}
	public AppRole(String rolename) {
		super();
		this.rolename = rolename;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
