package com.project.my.homeworks.hw7.q1;

public class Student extends Person {
	private Teacher[] teachers;

	protected Student(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public Teacher[] getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}

}
