package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

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
		result.append(Constants.formatter(color));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(size+""));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append("%s");
		return super.toString().formatted(result);
	}

}
