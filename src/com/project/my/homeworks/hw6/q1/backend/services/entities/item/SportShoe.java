package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class SportShoe extends Shoe {
	private static final double DISCOUNT = 0.2;

	public SportShoe(String color, int size, ShoeType type, String code, double price) {
		super(color, size, type, code, price, DISCOUNT, ItemCategory.SPORT_SHOE);
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString() + discount;
	}

}
