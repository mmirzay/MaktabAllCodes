package com.project.my.classcodes.day0702.bank.backend.entities;

public class User {
	private Integer id;
	private String name;

	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
}
