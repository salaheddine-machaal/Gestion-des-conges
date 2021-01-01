package com.app.service;
import java.util.ArrayList;
import java.util.Collection;

import com.app.dao.AppUserRepository;
import com.app.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService  {
	
	@Autowired
	private IAppUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		AppUser user = userService.findUserByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username + " not found!");
		Collection<GrantedAuthority> authority = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authority.add(new SimpleGrantedAuthority(role.getRolename()));
		});
		return new User(user.getUsername(), user.getPassword(), authority);
	}
}
