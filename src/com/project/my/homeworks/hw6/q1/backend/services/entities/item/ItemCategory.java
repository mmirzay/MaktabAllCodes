package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

public enum ItemCategory {
	SPORT_SHOE("Sport Shoe"), FORMAL_SHOE("Formal Shoe"), NEWSPAPER("Newspaper"), MAGAZINE("Magazine"), BOOK("Book"),
	LED_TV("LED TV"), LCD_TV("LCD TV"), ANALOG_RADIO("Analog Radio"), DIGITAL_RADIO("Digital Radio");

	private String value;

	ItemCategory(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
