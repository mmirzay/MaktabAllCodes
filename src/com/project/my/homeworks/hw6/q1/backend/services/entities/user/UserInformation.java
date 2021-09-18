package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class UserInformation {
	private Name name;
	private String phone;
	private Email email;
	private Address address;

	public UserInformation(Name name) {
		this(name, "", new Email(), new Address());
	}

	public UserInformation(Name name, String phone, Email email, Address address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(phone));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(email);
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(address);
		return result.toString();
	}

}
