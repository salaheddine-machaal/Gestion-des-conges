package com.app.service;

import java.util.List;

import com.app.entity.AppRole;
import com.app.entity.AppUser;

public interface IAppUserService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String rolename);
	public AppUser findUserByUsername(String username);
	public List<AppUser> getSubordinatesByManagerId(Long id);
}
