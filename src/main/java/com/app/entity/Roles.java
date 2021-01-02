package com.app.entity;

public enum Roles {
	EMPLOYEE("Employee"),
	MANAGER("Manager"),
	RH("Rh"),
	DG("Dg");
	
	private final String value;
	
	Roles(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean equals(String role) {
		return this.value.equals(role);
	}
}
