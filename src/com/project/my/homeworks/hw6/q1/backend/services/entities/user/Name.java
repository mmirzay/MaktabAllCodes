package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Name {

	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(Constants.formatter(firstName));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(lastName));
		return result.toString();
	}

}
