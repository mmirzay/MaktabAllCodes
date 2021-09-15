package com.project.my.homeworks.hw6.q1.entities;

public class Radio extends Electrical {
	private boolean chargeable;

	public Radio(String mark, boolean chargeable, String code, double price, double discount) {
		super(mark, code, price, discount);
		this.chargeable = chargeable;
	}

	public boolean isChargeable() {
		return chargeable;
	}

}
