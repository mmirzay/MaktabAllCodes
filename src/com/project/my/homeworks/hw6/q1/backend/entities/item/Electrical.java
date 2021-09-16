package com.project.my.homeworks.hw6.q1.backend.entities.item;

public class Electrical extends Item {
	private static final String CODE_IDENTIFIER = "E";
	private String mark;

	public Electrical(String mark, String code, double price, double discount) {
		super(CODE_IDENTIFIER + code, price, discount);
		this.mark = mark;
	}

	public String getMark() {
		return mark;
	}

}
