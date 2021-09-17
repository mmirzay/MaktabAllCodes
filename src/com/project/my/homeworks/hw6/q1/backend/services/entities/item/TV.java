package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class TV extends Electrical {
	private String sizeInch;

	public TV(String mark, int sizeInch, String code, double price, double discount, ItemCategory itemCataCategory) {
		super(mark, code, price, discount, itemCataCategory);
		this.sizeInch = sizeInch + "\"";
	}

	public String getSizeInch() {
		return sizeInch;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(sizeInch);
		result.append(" ");
		result.append("%s");
		return super.toString().formatted(result);
	}

}
