package com.project.my.homeworks.hw6.q1.entities.item;

public class Readable extends Item {
	private static final String CODE_IDENTIFIER = "R";
	private String title;

	public Readable(String title, String code, double price) {
		super(CODE_IDENTIFIER + code, price, 0);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
