package com.project.my.classcodes.day0626.polymorphism;

public class Rectangle extends Shape {
	private int length;
	private int width;

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	@Override
	protected void calculateArea() {
		int area = length * width;
		System.out.println("Rectangle area is " + area);
	}

}
