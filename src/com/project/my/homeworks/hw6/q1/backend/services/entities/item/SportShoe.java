package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class SportShoe extends Shoe {
	private static final double DISCOUNT = 0.2;

	public SportShoe(String color, int size, String code, double price) {
		super(color, size, code, price, DISCOUNT, ItemCategory.SPORT_SHOE);
	}

	@Override
	public String toString() {
		return super.toString().formatted(Constants.formatter(""));
	}

}
