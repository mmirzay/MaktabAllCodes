package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class AnalogRadio extends Radio {
	private static final double DISCOUNT = 0.2;
	private static final boolean CHARGEABLE = false;

	public AnalogRadio(String mark, String code, double price) {
		super(mark, CHARGEABLE, code, price, DISCOUNT, ItemCategory.ANALOG_RADIO);
	}

}
