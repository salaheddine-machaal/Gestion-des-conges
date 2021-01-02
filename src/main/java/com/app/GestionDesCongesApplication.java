package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.entity.AppRole;
import com.app.entity.AppUser;
import com.app.entity.Roles;
import com.app.service.IAppUserService;

@SpringBootApplication
public class GestionDesCongesApplication implements CommandLineRunner {

	@Autowired
	private IAppUserService userService;
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDesCongesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		AppRole roleEmp = userService.saveRole(new AppRole(Roles.EMPLOYEE.getValue()));
		AppRole roleManager = userService.saveRole(new AppRole(Roles.MANAGER.getValue()));
		AppRole roleRh = userService.saveRole(new AppRole(Roles.RH.getValue()));
		AppRole roleDg = userService.saveRole(new AppRole(Roles.DG.getValue()));
		
		userService.saveUser(new AppUser(1l, "emp", "123", roleEmp));
		userService.saveUser(new AppUser(1l, "manager", "123", roleManager));
		userService.saveUser(new AppUser(1l, "rh", "123", roleRh));
		userService.saveUser(new AppUser(1l, "dg", "123", roleDg));

	}

}
