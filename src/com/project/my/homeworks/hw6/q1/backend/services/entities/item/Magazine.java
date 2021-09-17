package com.project.my.homeworks.hw6.q1.backend.services.entities.item;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;

public class Magazine extends Readable {
	private MagazineType type;

	public Magazine(String title, MagazineType type, String code, double price) {
		super(title, code, price, ItemCategory.MAGAZINE);
		this.type = type;
	}

	public MagazineType getType() {
		return type;
	}

	@Override
	public String toString() {
		return super.toString().formatted(Constants.formatter(type.name()));
	}
}
