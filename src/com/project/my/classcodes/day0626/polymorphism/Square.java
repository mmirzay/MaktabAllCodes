package com.project.my.classcodes.day0626.polymorphism;

public class Square extends Shape {

	private int side;

	public Square(int side) {
		this.side = side;
	}

	@Override
	protected void calculateArea() {
		int area = side * side;
		System.out.println("Square area is " + area);
	}
}
