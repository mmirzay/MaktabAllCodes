package com.project.my.classcodes;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 30/8/2021
 */
public class MyFirstClass {

	public static void main(String[] args) {

		printFibo(1000);
		palindrome(1221);
		System.out.printf("%s%.2f%n", "Circle Area ( r = 5): ", circleArea(7));
		System.out.println("factorial: " + factorial(5));
		System.out.println("power of two: " + (isPowerOfTwo(64) ? "Yes" : "No"));
		System.out.println("Triangle (Ex. 3, 4 ,5): " + (isTriangle(3, 4, 5) ? "Yes" : "No"));
		System.out.println("Some Calculation: " + someIntegerCalculation(8, 3));
		System.out.println("Multiply: " + multiply(9, 4));
		System.out.println("Devide: " + divide(9, 4));
		System.out.printf("%s%.2f%n", "Salary: ", calculateSalary(888000, 10));
		validateId(4569581323L);
		String m = " Mohsen Mirzay is Mohsen Mirzay of Java Mirzay Nothing but Java is Java and JavaForEver";
		System.out.println(countDuplicates(m, "Mohsen"));
		System.out.println("input: " + "1100120011010101");
		System.out.println("result: " + orderZeroAndOnesInBinaryFormattedString("110011001010101"));
		System.out.println("isPalindrome: " + isPalindrome("MohseneshoM"));
		System.out.println("evenOddsDigit: " + evenOddFourDigitNumber(521));
		System.out.println(minimumCoins(2860));
		System.out.println(calculateSerie(3, 1));
		printRectangularStars(7, 10);
		findMinMaxOfArray(new int[] { 22, 45, 65, 12, 44, 64, 2, 21, 33 });
		randomArray(4, 4, 20);

	}

	static void printFibo(long sum) {
		System.out.print("Fobonacci: ");
		int seqNumber = 1;
		while (fibonacci(seqNumber) <= sum)
			System.out.printf("%d%s", fibonacci(seqNumber++), " ");
		System.out.println();
	}

	static long fibonacci(long n) {
		if (n == 1 || n == 2)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	static void palindrome(long n) {
		long palindrome = 0;
		long number = n;
		while (number > 0) {
			palindrome = palindrome * 10 + number % 10;
			number /= 10;
		}
		System.out.println(palindrome == n ? "Palindrome" : "Not Palindrome");
	}

	static double circleArea(int radius) {
		return Math.PI * (radius * radius);
	}

	static long factorial(long n) {
		return n <= 1 ? 1 : n * factorial(n - 1);
	}

	static boolean isPowerOfTwo(int n) {
		int pow = Integer.numberOfTrailingZeros(n);
		int number = 0x1 << pow;
		return n == number;
	}

	static boolean isTriangle(int a, int b, int c) {
		return a + b > c && a + c > a && b + c > a;
	}

	static int someIntegerCalculation(int m, int n) {
		return m + 3 * n - m % 2 + ++n * 3 / m - 1;
	}

	static int multiply(int m, int n) {
		int result = 0;
		for (int i = 0; i < m; i++)
			result += n;
		return result;
	}

	static int divide(int m, int n) {
		int result = 0;
		while (m >= n) {
			m -= n;
			result++;
		}
		return result;
	}

	static double calculateSalary(double fixedSalary, int extraHours) {
		return fixedSalary + fixedSalary / 192 * 1.4 * extraHours;
	}

	static void validateId(long tenDigitsNumber) {
		if (String.valueOf(tenDigitsNumber).length() != 10) {
			System.out.println("must enter 10 digit number");
			return;
		}
		long temp = tenDigitsNumber;
		int a = 0;
		int position = 1;
		int c;
		while (temp > 0) {
			if (position != 1)
				a += temp % 10 * position;
			temp /= 10;
			position++;
		}
		c = a % 11 < 2 ? a % 11 : 11 - a % 11;
		System.out.println("ID is " + (c == tenDigitsNumber % 10 ? "valid." : "invalid."));
	}

	static int countDuplicates(String source, String find) {
		int counter = 0;
		while (source.indexOf(find) > -1) {
			counter++;
			source = source.substring(source.indexOf(find) + find.length());
		}
		return counter;
	}

	static String orderZeroAndOnesInBinaryFormattedString(String bfs) {
		String result = "";
		for (char c : bfs.toCharArray())
			result = switch (c) {
			case '0' -> c + result;
			case '1' -> result + c;
			default -> throw new IllegalArgumentException("Unexpected value: " + c);
			};
		return result;
	}

	static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end)
			if (str.charAt(start++) != str.charAt(end--))
				return false;
		return true;
	}

	static double evenOddFourDigitNumber(int num) {
		float evensMultiplication = 1;
		float oddsMultiplication = 1;
		while (num > 0) {
			int digit = num % 10;
			if (digit % 2 == 0)
				evensMultiplication *= digit;
			else
				oddsMultiplication *= digit;
			num /= 10;
		}
		return evensMultiplication / oddsMultiplication;
	}

	static double calculateFinalSalary(double fixed) {
		return fixed - fixed * 0.07 - fixed * (fixed > 4_000_000 ? 0.1 : 0);
	}

	static String minimumCoins(int money) {
		System.out.println("Poolemoon: " + money);
		int hezar = 0;
		int pansad = 0;
		int sad = 0;
		int panjah = 0;
		int dah = 0;
		while (money >= 10) {
			hezar = money / 1000;
			money %= 1000;
			pansad = money / 500;
			money %= 500;
			sad = money / 100;
			money %= 100;
			panjah = money / 50;
			money %= 50;
			dah = money / 10;
			money %= 10;
		}
		return String.format(hezar != 0 ? "%d sekeye hezar tomani\n" : "", hezar)
				+ String.format(pansad != 0 ? "%d sekeye pansad tomani\n" : "", pansad)
				+ String.format(sad != 0 ? "%d sekeye sad tomani\n" : "", sad)
				+ String.format(panjah != 0 ? "%d sekeye panjah tomani\n" : "", panjah)
				+ String.format(dah != 0 ? "%d sekeye dah tomani\n" : "", dah);
	}

	static double calculateSerie(int n, int x) {
		double result = 0;
		for (int s = 1; s <= n; s++) {
			long denominator = 0;
			for (int i = 1; i <= s + 1; i++)
				denominator += i * Math.pow(x, i);
			result += 1.0 / denominator;
		}
		return result;
	}

	static void printRectangularStars(int w, int h) {
		for (int i = 1; i <= w; i++)
			System.out.print("*");
		System.out.println();
		for (int j = 1; j <= h - 2; j++) {
			System.out.print("*");
			for (int i = 1; i <= w - 2; i++)
				System.out.print(" ");
			System.out.println("*");
		}
		for (int i = 1; i <= w; i++)
			System.out.print("*");
		System.out.println();
	}

	static double finalPrice(double price, int discountPercentage) {
		return price - price * discountPercentage / 100;
	}

	static void printTrianulOfNumbers(int n) {

	}

	static void findMinMaxOfArray(int[] array) {
		System.out.print("Array: [");
		for (int i = 0; i < array.length; i++)
			if (i != array.length - 1)
				System.out.print(array[i] + " , ");
			else
				System.out.println(array[i] + "]");
		int max = 0;
		int maxIndex = -1;
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}

		System.out.printf("Max number is %d at cell index %d%n", max, maxIndex);
		System.out.printf("Min number is %d at cell index %d%n", min, minIndex);

	}

	static void randomArray(int m, int n, int maxRandom) {
		int[][] randomArray = new int[m][n];
		System.out.println("Random Array:");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				randomArray[i][j] = new Random().nextInt(maxRandom + 1);
				System.out.print(randomArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Sorted Array:");

		for (int i = 0; i < m; i++)
			Arrays.sort(randomArray[i]);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(randomArray[i][j] + " ");
			System.out.println();
		}
	}

}
