package com.app.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class AppUser {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	
	@ManyToOne()
	@JoinColumn(name="manager_id")
	private AppUser manager;
	
	@OneToMany(mappedBy="manager")
	private Set<AppUser> subordinates = new HashSet();
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList();
	
	@OneToMany(fetch=FetchType.LAZY)
	private Collection<Demande> demandes = new ArrayList();
	
	
	public AppUser() {
		super();
	}

	public AppUser(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public AppUser(Long id, String username, String password, AppRole role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles.add(role);
	}
	
	public AppUser(Long id, String username, String password, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(Collection<Demande> demandes) {
		this.demandes = demandes;
	}
		
}
