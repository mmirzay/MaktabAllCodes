package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Item {
	private String code;
	private double price;
	private double discount;
	private ItemCategory itemCategory;

	protected Item(String code, double price, double discount, ItemCategory itemCategory) {
		this.code = code;
		this.price = price;
		this.discount = discount;
		this.itemCategory = itemCategory;
	}

	public Item(String code, double price) {
		this(code, price, 0, null);
	}

	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(Constants.formatter(code));
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append("%s");
		result.append(Constants.COLUMNS_SEPARATOR);
		result.append(Constants.formatter(String.format("%,.2f", price)));
		return result.toString();
	}
}
