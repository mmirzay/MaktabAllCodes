package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Email {
	private String value;

	public Email() {
		this("");
	}

	public Email(String email) {
		this.value = email;
	}

	public String get() {
		return value;
	}

	public void set(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Constants.formatter(value);
	}

}
