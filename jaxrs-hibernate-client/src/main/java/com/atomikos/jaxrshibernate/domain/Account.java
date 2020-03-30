package com.atomikos.jaxrshibernate.domain;

public class Account {

	private Long id;

	private String username;

	Account() {
	}
	
	public Long getId() {
		return id;
	}

	public Account(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

}