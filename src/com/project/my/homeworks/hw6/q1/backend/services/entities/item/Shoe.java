package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class Shoe extends Item {
	private static final String CODE_IDENTIFIER = "S";
	private int size;
	private String color;

	public Shoe(String color, int size, String code, double price, double discount, ItemCategory itemCataCategory) {
		super(CODE_IDENTIFIER + code, price, discount, itemCataCategory);
		this.size = size;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(color);
		result.append(" ");
		result.append(size);
		result.append(" ");
		result.append("%s");
		return super.toString().formatted(result);
	}

}
