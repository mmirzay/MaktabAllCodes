package com.project.my.homeworks.hw6.q1.entities;

public class Newspaper extends Readable {
	private String date;

	public Newspaper(String title, String date, String code, double price) {
		super(title, code, price);
		this.date = date;
	}

	public String getDate() {
		return date;
	}

}
