package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public class Radio extends Electrical {
	private boolean chargeable;

	public Radio(String mark, boolean chargeable, String code, double price, double discount,
			ItemCategory itemCataCategory) {
		super(mark, code, price, discount, itemCataCategory);
		this.chargeable = chargeable;
	}

	public boolean isChargeable() {
		return chargeable;
	}

	@Override
	public String toString() {
		return super.toString().formatted(chargeable ? "Yes" : "No");
	}

}
