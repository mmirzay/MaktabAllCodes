package com.project.my.homeworks.hw6.q1.entities.item;

public class DigitalRadio extends Radio {
	private static final double DISCOUNT_IF_NOT_CHARGEABLE = 0.1;

	public DigitalRadio(String mark, boolean chargeable, String code, double price) {
		super(mark, chargeable, code, price, chargeable ? 0 : DISCOUNT_IF_NOT_CHARGEABLE);
	}

}
