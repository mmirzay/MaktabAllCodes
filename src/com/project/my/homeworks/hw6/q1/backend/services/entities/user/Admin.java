package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

public class Admin extends User {

	public Admin() {
		this("admin", "admin", "Admin", "");
	}

	private Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	@Override
	public boolean isAdmin() {
		return true;
	}

}
