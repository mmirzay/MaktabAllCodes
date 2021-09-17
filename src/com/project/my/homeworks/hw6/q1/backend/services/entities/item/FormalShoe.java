package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class FormalShoe extends Shoe {
	private FormalShoeType type;
	private static final double DISCOUNT_IF_IS_FOR_KIDS = 0.2;

	public FormalShoe(String color, FormalShoeType type, int size, String code, double price) {
		super(color, size, code, price, type == FormalShoeType.KIDS ? DISCOUNT_IF_IS_FOR_KIDS : 0,
				ItemCategory.FORMAL_SHOE);
		this.type = type;
	}

	public FormalShoeType getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		if (getDiscount() != 0) {
			discount.append(Constants.COLUMNS_SEPARATOR);
			discount.append(Constants.formatter((int) (getDiscount() * 100) + "%"));
		}
		return super.toString().formatted(Constants.formatter(type.name())) + discount;
	}

}
