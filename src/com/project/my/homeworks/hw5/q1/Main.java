package com.project.my.homeworks.hw5.q1;

public class Main {
	public static void main(String[] args) {
		int number = 13;
		System.out.printf("Number %d is %s.", number, isPrime(number) ? "Prime" : "NOT Prime");
	}

	private static boolean isPrime(int num, int... i) {
		if (num == 2)
			return true;
		if (num < 2)
			return false;		
		if (i.length == 0) {
			i = new int[1];
			i[0] = num / 2;
		}
		if(i[0] < 2)
			return true;
		if (num % i[0] == 0)
			return false;
		return isPrime(num, i[0] - 1);
	}
}
