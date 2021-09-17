package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

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
		return super.toString().formatted(Constants.formatter(chargeable ? "Yes" : "No"));
	}

}
