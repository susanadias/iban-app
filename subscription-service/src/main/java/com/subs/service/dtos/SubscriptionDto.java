package com.subs.service.dtos;

import java.io.Serializable;

public class SubscriptionDto implements Serializable {
	private String name;
	private String email;
	
	
	
	
	public SubscriptionDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
    
}
