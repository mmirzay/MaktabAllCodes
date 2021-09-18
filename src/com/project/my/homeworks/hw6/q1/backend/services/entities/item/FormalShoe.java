package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class FormalShoe extends Shoe {
	private static final double DISCOUNT_IF_IS_FOR_KIDS = 0.2;

	public FormalShoe(String color, ShoeType type, int size, String code, double price) {
		super(color, size, type, code, price, type == ShoeType.KIDS ? DISCOUNT_IF_IS_FOR_KIDS : 0,
				ItemCategory.FORMAL_SHOE);
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString()+ discount;
	}

}
