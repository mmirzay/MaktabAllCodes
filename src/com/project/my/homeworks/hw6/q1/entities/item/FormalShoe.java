package com.project.my.homeworks.hw6.q1.entities.item;

public class FormalShoe extends Shoe {
	private FormalShoeType type;
	private static final double DISCOUNT_IF_IS_FOR_KIDS = 0.2;

	public FormalShoe(String color, FormalShoeType type, int size, String code, double price) {
		super(color, size, code, price, type == FormalShoeType.KIDS ? DISCOUNT_IF_IS_FOR_KIDS : 0);
		this.type = type;
	}

	public FormalShoeType getType() {
		return type;
	}

}
