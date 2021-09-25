package com.project.my.homeworks.hw7.q1;

public class Person {
	private int id;
	private String firstName;
	private String lastName;

	protected Person(int id, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
