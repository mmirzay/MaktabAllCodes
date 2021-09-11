package com.project.my.classcodes.toyfactory.entities;

public class Car extends Toy {

	public Car(int id, double basePrice, ToySize size) {
		super(id, basePrice, size);
	}

	@Override
	public double getPrice() {
		if (getSize() == ToySize.MEDIUM)
			return getBasePrice() * 2.5;
		else if (getSize() == ToySize.LARGE)
			return getBasePrice() * 3;
		return getBasePrice() * 2;
	}

}
