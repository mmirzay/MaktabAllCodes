package com.project.my.homeworks.hw4.q1;

public class Main {
	public static void main(String[] args) {
		int number = 13574532;
		System.out.println(sumDigits(number));
	}

	private static int sumDigits(long number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			if (sum >= 10)
				sum -= 9;
			number /= 10;
		}
		return sum;
	}
}
