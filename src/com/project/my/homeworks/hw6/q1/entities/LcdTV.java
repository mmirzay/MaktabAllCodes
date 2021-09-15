package com.project.my.homeworks.hw6.q1.entities;

public class LcdTV extends TV {
	private static final double DISCOUNT = 0.1;

	public LcdTV(String mark, int sizeInch, String code, double price) {
		super(mark, sizeInch, code, price, DISCOUNT);
	}

}
