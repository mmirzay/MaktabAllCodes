package com.project.my.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 3/9/2021
 */
public class Exercise1 {
	public static void main(String[] args) {
		int randomInt = new Random().nextInt(100) + 1;
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter guessing number:\n-> ");
			if (isGuessed(input.nextInt(), randomInt)) {
				System.out.printf("You guessed correctly in %d turn(s)%n", i + 1);
				break;
			}
		}
	}

	private static boolean isGuessed(int num1, int num2) {
		if (num1 == num2)
			return true;
		if (num1 > num2)
			System.out.println("Guessed Number is more than randomized number.");
		else
			System.out.println("Guessed Number is lower than randomized number.");
		return false;
	}
}
