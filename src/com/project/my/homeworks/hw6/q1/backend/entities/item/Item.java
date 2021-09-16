package com.project.my.homeworks.hw6.q1.backend.entities.item;

public class Item {
	private String code;
	private double price;
	private double discount;

	public Item(String code, double price, double discount) {
		this.code = code;
		this.price = price;
		this.discount = discount;
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

}
