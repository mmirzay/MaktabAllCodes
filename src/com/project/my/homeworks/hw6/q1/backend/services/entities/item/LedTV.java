package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class LedTV extends TV {
	private static final double DISCOUNT_IF_NOT_SMART = 0.05;
	private boolean smart;

	public LedTV(String mark, boolean smart, int sizeInch, String code, double price) {
		super(mark, sizeInch, code, price, smart ? 0 : DISCOUNT_IF_NOT_SMART,ItemCategory.LED_TV);
		this.smart = smart;
	}

	public boolean isSmart() {
		return smart;
	}

}
