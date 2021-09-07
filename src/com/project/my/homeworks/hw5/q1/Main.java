package com.project.my.homeworks.hw5.q1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter an Integer number >> ");
		int number = input.nextInt();
		System.out.printf(">> Number %d is %s. <<%n", number, isPrime(number) ? "Prime" : "NOT Prime");
		input.nextLine();
		System.out.println("Press Enter to continue...");
		input.nextLine();
		int maxRange = 100;
		System.out.printf("List of Prime Numbers up to %d:%n", maxRange);
		for (int i = 2; i < maxRange; i++)
			if (isPrime(i))
				System.out.print(i + " ");
		System.out.println();
		input.close();
	}

	private static boolean isPrime(int num, int... i) {
		if (num == 2)
			return true;
		if (num < 2 || num % 2 == 0)
			return false;
		if (i.length == 0) {
			i = new int[1];
			i[0] = 2;
		}
		if (i[0] * i[0] > num)
			return true;
		if (num % i[0] == 0)
			return false;
		return isPrime(num, i[0] + 1);
	}
}
