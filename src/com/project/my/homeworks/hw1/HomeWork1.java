package com.project.my.homeworks.hw1;

import java.util.Scanner;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/9/2021
 */
public class HomeWork1 {

	public static void main(String[] args) {
		HomeWork1 hw1 = new HomeWork1();
		String test = "ABC";
		System.out.println("input: printPermutations(\"" + test + "\")");
		System.out.println("output: " + hw1.printPermutations(test));
		String one = "golgoli";
		String two = "gol";
		System.out.println("input: stringInString(\"" + one + "\",\"" + two + "\")");
		System.out.println("output: " + hw1.stringInString(one, two));
		one = "sasasas";
		two = "sas";
		System.out.println("input: stringInString(\"" + one + "\",\"" + two + "\")");
		System.out.println("output: " + hw1.stringInString(one, two));
		System.out.println("Find Maximum");
		hw1.findMaximum();
	}

	/**
	 * This method takes a string as its input and then prints different permutation
	 * of all character of it.<br/>
	 * <i> Note: The word characters must not have any duplicates.</i><br/>
	 * <i> Note: I implemented a non-recursive version.</i>
	 *
	 * @param str The word with different characters to print different permutations
	 */
	public String printPermutations(String str) {
		int fact = 1;
		for (int i = 1; i <= str.length(); i++)
			fact *= i;

		int permutationNumbers = fact;
		String[] result = new String[permutationNumbers];
		result[0] = str;
		for (int permutationIndex = 0; permutationIndex < result.length; permutationIndex++) {
			String sourceString = result[permutationIndex];
			String[] permutaions = new String[sourceString.length()];
			for (int j = 0; j < sourceString.length(); j++) {
				String p = sourceString.charAt(j) + "";
				for (int k = 0; k < str.length(); k++)
					if (j != k)
						p += sourceString.charAt(k);
				permutaions[j] = p;
			}

			outer: for (int i = 0; i < permutaions.length; i++) {
				for (int j = 0; j < result.length; j++) {
					if (result[j] == null) {
						result[j] = permutaions[i];
						continue outer;
					} else if (result[j].equals(permutaions[i]))
						continue outer;
				}
			}
		}

		String output = "[";
		for (int i = 0; i < result.length; i++)
			if (i != result.length - 1)
				output += "\"" + result[i] + "\",";
			else
				output += "\"" + result[i];
		output += "\"]";
		return output;
	}

	/**
	 * This method takes two string and find number of occurrences of second string
	 * in first string.
	 *
	 * @param source The string to find occurrences in it.
	 * @param find   The string to find occurrences of it.
	 * @return number of occurrences or 0 if source or find is null.
	 */
	public int stringInString(String source, String find) {
		if (source == null || find == null)
			return 0;

		int counter = 0;
		for (int i = 0; i < source.length(); i++)
			if (i + find.length() > source.length())
				break;
			else if (find.equals(source.substring(i, i + find.length())))
				counter++;

		return counter;
	}

	/**
	 * This method receive {@code n} number of user using {@link java.util.Scanner}
	 * and then after finding maximum number of them, it prints the maximum number
	 * and the turn which this number is entered by user.
	 *
	 */
	public void findMaximum() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n:\n-> ");
		int n = input.nextInt();
		int max = Integer.MIN_VALUE;
		int maxTurn = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter number #" + i + ":\n-> ");
			int newNumber = input.nextInt();
			if (newNumber > max) {
				max = newNumber;
				maxTurn = i;
			}
		}
		System.out.printf("Maximum number is %d, entered in turn %d", max, maxTurn);
		input.close();
	}
}
