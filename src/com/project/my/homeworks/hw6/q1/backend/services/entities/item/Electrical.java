package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class Electrical extends Item {
	private static final String CODE_IDENTIFIER = "E";
	private String mark;

	public Electrical(String mark, String code, double price, double discount, ItemCategory itemCataCategory) {
		super(CODE_IDENTIFIER + code, price, discount,itemCataCategory);
		this.mark = mark;
	}

	public String getMark() {
		return mark;
	}

}
