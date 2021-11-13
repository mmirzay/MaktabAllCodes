package com.project.my.homeworks.hw14.q1;

import java.util.function.DoubleBinaryOperator;

public class AvgFunction {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 15;
		DoubleBinaryOperator avgFunction = (l, r) -> (l + r) / 2;
		System.out.printf("Average of %s and %s is: %.2f", num1, num2, avgFunction.applyAsDouble(num1, num2));
	}
}
