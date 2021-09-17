package com.project.my.homeworks.hw6.q1.backend.entities.item;

public class Item {
	private String code;
	private double price;
	private double discount;
	private ItemCategory itemCategory;

	public Item(String code, double price, double discount, ItemCategory itemCategory) {
		this.code = code;
		this.price = price;
		this.discount = discount;
		this.itemCategory = itemCategory;
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

}
