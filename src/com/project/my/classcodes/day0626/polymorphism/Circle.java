package com.project.my.classcodes.day0626.polymorphism;

public class Circle extends Shape {

	private int r;
	public Circle(int radius) {
		this.r = radius;
	}
	@Override
	public void calculateArea() {
		double area = Math.PI * r * r;
		System.out.println("Circle area is " + area);
	}

}
