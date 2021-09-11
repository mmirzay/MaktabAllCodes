package com.project.my.classcodes.toyfactory.entities;

public class Toy {
	private int id;
	private double basePrice;

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	private ToySize size;

	public Toy(int id, double basePrice, ToySize size) {
		this.id = id;
		this.basePrice = basePrice;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		if (getSize() == ToySize.MEDIUM)
			return getBasePrice() * 1.5;
		else if (getSize() == ToySize.LARGE)
			return getBasePrice() * 2;
		return getBasePrice();
	}

	public double getPrice(int discount) {
		return getPrice() * (100 - discount) / 100;
	}

	public ToySize getSize() {
		return size;
	}

	public double getBasePrice() {
		return basePrice;
	}

}
