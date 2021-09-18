package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Newspaper extends Readable {
	private String date;

	public Newspaper(String title, String date, String code, double price) {
		super(title, code, price, ItemCategory.NEWSPAPER);
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString().formatted(Constants.formatter(date)) + discount;
	}

}
