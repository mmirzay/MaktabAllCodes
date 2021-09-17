package com.project.my.classcodes.day0626.polymorphism;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Select a shape: 1- Circle 2-Square 3-Rectangle 4- Triangle");
		Shape shape;
		switch (input.nextInt()) {
		case 1:
			System.out.println("Enter radius: ");
			int radius = input.nextInt();
			shape = new Circle(radius);
			break;
		case 2:
			System.out.println("Enter side: ");
			int side = input.nextInt();
			shape = new Square(side);
			break;
		case 3:
			System.out.println("Enter length: ");
			int length = input.nextInt();
			System.out.println("Enter width: ");
			int width = input.nextInt();
			shape = new Rectangle(length, width);
			break;
		case 4:
			System.out.println("Enter base: ");
			int base = input.nextInt();
			System.out.println("Enter height: ");
			int height = input.nextInt();
			shape = new Triangle(base, height);
			break;
		default:
			shape = new Shape();
		}

		shape.calculateArea();
		input.close();
	}
}
