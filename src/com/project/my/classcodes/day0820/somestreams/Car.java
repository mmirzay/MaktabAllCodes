package com.project.my.classcodes.day0820.somestreams;

public class Car {
	private int price;
	private String name;
	
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Car [price=" + price + ", name=" + name + "]";
	}
	
	
}
