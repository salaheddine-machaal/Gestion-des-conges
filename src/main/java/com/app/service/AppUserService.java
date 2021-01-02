package com.app.service;

import com.app.dao.AppRoleRepository;
import com.app.dao.AppUserRepository;
import com.app.entity.AppRole;
import com.app.entity.AppUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService  {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private AppRoleRepository roleRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hash = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppRole role = roleRepository.findByRolename(rolename);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<AppUser> getSubordinatesByManagerId(Long id){
		return userRepository.findByManagerId(id);
	}
}
