package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.AppUser;
import com.app.service.IAppUserService;

@RestController
public class UserController {

	@Autowired
	private IAppUserService userService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody AppUser user) {
		userService.saveUser(user);
		return user;
	}
	
	
	
}
