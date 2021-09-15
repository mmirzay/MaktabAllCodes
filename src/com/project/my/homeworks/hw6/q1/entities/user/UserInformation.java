package com.project.my.homeworks.hw6.q1.entities.user;

public class UserInformation {
	private Name name;
	private String phone;
	private Email email;
	private Address address;

	public UserInformation(Name name) {
		this(name, null, null, null);
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
}
