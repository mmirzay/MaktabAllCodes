package com.project.my.homeworks.hw6.q1.backend.entities.item;

public class TV extends Electrical {
	private String sizeInch;

	public TV(String mark, int sizeInch, String code, double price, double discount, ItemCategory itemCataCategory) {
		super(mark, code, price, discount, itemCataCategory);
		this.sizeInch = sizeInch + "\"";
	}

	public String getSizeInch() {
		return sizeInch;
	}

}
