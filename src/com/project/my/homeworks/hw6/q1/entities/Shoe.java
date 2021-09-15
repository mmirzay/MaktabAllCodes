package com.project.my.homeworks.hw6.q1.entities;

public class Shoe extends Item {
	private static final String CODE_IDENTIFIER = "S";
	private int size;
	private String color;

	public Shoe(String color, int size, String code, double price, double discount) {
		super(CODE_IDENTIFIER + code, price, discount);
		this.size = size;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

}
