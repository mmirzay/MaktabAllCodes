package com.project.my.classcodes.day0626.polymorphism;

public class Triangle extends Shape {

	private int height;
	private int base;

	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	@Override
	protected void calculateArea() {
		double area = base * height / 2d;
		System.out.println("Triangle area is " + area);
	}
}
