package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class AnalogRadio extends Radio {
	private static final double DISCOUNT = 0.2;
	private static final boolean CHARGEABLE = false;

	public AnalogRadio(String mark, String code, double price) {
		super(mark, CHARGEABLE, code, price, DISCOUNT, ItemCategory.ANALOG_RADIO);
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString() + discount;
	}
}
