package com.revature.pojo;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	private String Type;

	public User() {
		super();
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
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}