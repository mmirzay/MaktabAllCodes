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

	@Override
	public String toString() {
		String type = "Person";
		if (this instanceof Teacher)
			type = "Teacher";
		else if (this instanceof Student)
			type = "Student";
		return String.format("%s ID: %d Name: %s %s.", type, id, firstName, lastName);
	}

}
