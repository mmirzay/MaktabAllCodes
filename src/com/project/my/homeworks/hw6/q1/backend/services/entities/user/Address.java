package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Address {
	private String state;
	private String city;
	private String street;
	private String postalCode;

	public Address() {
		this("", "", "", "");
	}

	public Address(String state, String city, String street, String postalCode) {
		this.state = state;
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(Constants.formatter(state));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(city));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(street));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(postalCode));
		return result.toString();
	}

}
