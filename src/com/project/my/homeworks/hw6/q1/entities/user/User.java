package com.project.my.homeworks.hw6.q1.entities.user;

public class User {
	private Credential credential;
	private UserInformation info;

	public User(String username, String password, String firstName, String lastName) {
		credential = new Credential(username, password);
		info = new UserInformation(new Name(firstName, lastName));
	}

	public String getUsername() {
		return credential.getUsername();
	}

	public boolean checkAuthority(String username, String password) {
		return credential.checkUserName(username) && credential.checkPassword(password);
	}

	public String getFullName() {
		return info.getName().getFirstName() + " " + info.getName().getLastName();
	}

	public boolean isAdmin() {
		return false;
	}

}
