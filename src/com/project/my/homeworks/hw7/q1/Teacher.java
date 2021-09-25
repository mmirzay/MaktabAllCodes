package com.project.my.homeworks.hw7.q1;

public class Teacher extends Person {
	private Student[] students;

	protected Teacher(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

}
