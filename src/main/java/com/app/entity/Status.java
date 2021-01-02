package com.app.entity;

public enum Status {
	CREATED("Created"),
	ACCEPTED("Accepted"),
	VALIDATED("Validated"),
	GRANTED("Granted"),
	REFUSED("Refused");
	
	private final String value;
	
	Status(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean equals(String role) {
		return this.value.equals(role);
	}
}
