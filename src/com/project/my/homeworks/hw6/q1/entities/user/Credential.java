package com.project.my.homeworks.hw6.q1.entities.user;

public class Credential {
	private String username;
	private String password;

	public Credential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean checkUserName(String username) {
		return this.username.equalsIgnoreCase(username);
	}

	public boolean checkPassword(String passowrd) {
		return this.password.equals(passowrd);
	}

}
