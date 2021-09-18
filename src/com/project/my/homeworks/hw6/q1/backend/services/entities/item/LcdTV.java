package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class LcdTV extends TV {
	private static final double DISCOUNT = 0.1;

	public LcdTV(String mark, int sizeInch, String code, double price) {
		super(mark, sizeInch, code, price, DISCOUNT, ItemCategory.LCD_TV);
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString().formatted(Constants.formatter("No")) + discount;
	}
}
