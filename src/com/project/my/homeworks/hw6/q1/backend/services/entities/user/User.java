package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

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

	public void setFullName(String firstName, String lastName) {
		info.getName().setFirstName(firstName);
		info.getName().setLastName(lastName);
	}

	public String getPhone() {
		return info.getPhone();
	}

	public void setPhone(String phone) {
		info.setPhone(phone);
	}

	public String getEmail() {
		return info.getEmail().get();
	}

	public void setEmail(String email) {
		info.getEmail().set(email);
	}

	public String getState() {
		return info.getAddress().getState();
	}

	public void setState(String state) {
		info.getAddress().setState(state);
	}

	public String getCity() {
		return info.getAddress().getCity();
	}

	public void setCity(String city) {
		info.getAddress().setCity(city);
	}

	public String getStreet() {
		return info.getAddress().getStreet();
	}

	public void setStreet(String street) {
		info.getAddress().setStreet(street);
	}

	public String getPostalCode() {
		return info.getAddress().getPostalCode();
	}

	public void setPostalCode(String code) {
		info.getAddress().setPostalCode(code);
	}

	public boolean isAdmin() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(credential);
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(info);
		return result.toString();
	}

}
