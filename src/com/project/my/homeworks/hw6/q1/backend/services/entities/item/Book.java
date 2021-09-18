package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Book extends Readable {
	private String authorName;

	public Book(String title, String authorName, String code, double price) {
		super(title, code, price, ItemCategory.BOOK);
		this.authorName = authorName;

	}

	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString().formatted(Constants.formatter(authorName)) + discount;
	}

}
