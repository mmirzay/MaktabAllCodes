package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class Readable extends Item {
	private static final String CODE_IDENTIFIER = "R";
	private String title;

	public Readable(String title, String code, double price, ItemCategory itemCataCategory) {
		super(CODE_IDENTIFIER + code, price, 0, itemCataCategory);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(title);
		result.append(" ");
		result.append("%s");
		return super.toString().formatted(result);
	}

}
