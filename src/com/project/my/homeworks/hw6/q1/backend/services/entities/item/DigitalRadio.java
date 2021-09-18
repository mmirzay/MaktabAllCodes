package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class DigitalRadio extends Radio {
	private static final double DISCOUNT_IF_NOT_CHARGEABLE = 0.1;

	public DigitalRadio(String mark, boolean chargeable, String code, double price) {
		super(mark, chargeable, code, price, chargeable ? 0 : DISCOUNT_IF_NOT_CHARGEABLE, ItemCategory.DIGITAL_RADIO);
	}

	@Override
	public String toString() {
		StringBuilder discount = new StringBuilder("");
		discount.append(Constants.COLUMNS_SEPARATOR);
		discount.append(Constants.formatter(getDiscount() != 0 ? (int) (getDiscount() * 100) + "%" : ""));
		return super.toString() + discount;
	}

}
