package com.revature.pojo;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	protected String type;

	public User() {
		super();
	}

	public User(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		type = type;
	}

	public User(String type) {
		super();
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}