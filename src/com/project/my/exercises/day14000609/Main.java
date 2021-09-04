package com.project.my.exercises.day14000609;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] line = input.nextLine().toCharArray();
		char[] result = new char[line.length];
		int eqCounter = 0;
		int index = result.length - 1;
		for (int i = line.length - 1; i >= 0; i--)
			if (line[i] == '=')
				eqCounter++;
			else if (eqCounter > 0)
				eqCounter--;
			else
				result[index--] = line[i];
		for (int i = index + 1; i < result.length; i++)
			System.out.print(result[i]);

		input.close();
	}
}