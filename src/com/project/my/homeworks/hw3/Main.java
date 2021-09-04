package com.project.my.homeworks.hw3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] arr = { "loa", "azo", "ft", "amn", "lka" };
		String str = "amazon";
		System.out.println("===============================");
		System.out.println("Question one:");
		questionOne(arr, str);

		System.out.println("===============================");
		System.out.println("Question two:");
		String test = "Hello, How are you? Today is good!!0123456789";
		questionTwo(test);

		System.out.println("===============================");
		System.out.println("Question Three:");
		int[] input1 = { 2, 0, 2 };
		questionThree(input1);
		int[] input2 = { 3, 0, 2, 0, 4 };
		questionThree(input2);
		int[] input3 = { 3, 0, 2, 0, 2, 4 };
		questionThree(input3);
		int[] input4 = { 3, 0, 2, 0, 2, 0, 4 };
		questionThree(input4);

		System.out.println("===============================");
		System.out.println("Question Four:");
		int[] bigger1 = { 4, 3, 2, 1 };
		int[] smaller1 = { 4, 3, 1 };
		questionFour(bigger1, smaller1);
		int[] bigger2 = { 4, 3, 2, 1 };
		int[] smaller2 = { 5, 3, 1 };
		questionFour(bigger2, smaller2);

		System.out.println("===============================");
		System.out.println("Question Five:");
		questionFive();
	}

	public static void questionOne(String[] arr, String str) {
		System.out.print("Input: [");
		for (int i = 0; i < arr.length - 1; i++)
			System.out.print(arr[i] + ",");
		System.out.print(arr[arr.length - 1] + "] & " + str);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if (str.lastIndexOf(arr[i]) >= 0)
				str = str.replaceAll(arr[i], "");
			if (str.isEmpty()) {
				System.out.println("Output: Yes");
				return;
			}
		}
		System.out.println("Output: No");
	}

	public static void questionTwo(String str) {
		System.out.println("Input: " + str);
		int letters = 0;
		int numbers = 0;
		int spaces = 0;
		int others = 0;
		for (char ch : str.toCharArray())
			if (Character.isLetter(ch))
				letters++;
			else if (Character.isDigit(ch))
				numbers++;
			else if (Character.isWhitespace(ch))
				spaces++;
			else
				others++;

		System.out.printf("Output:%n -Letter: %d%n -Number: %d%n -Space: %d%n -Other: %d%n", letters, numbers, spaces,
				others);
	}

	public static void questionThree(int[] input) {
		int n = input.length;
		int[] highestBarInLeft = new int[n];
		int[] highestBarInRight = new int[n];

		highestBarInLeft[0] = input[0];
		for (int i = 1; i < n; i++)
			highestBarInLeft[i] = Math.max(highestBarInLeft[i - 1], input[i]);

		highestBarInRight[n - 1] = input[n - 1];
		for (int i = n - 2; i >= 0; i--)
			highestBarInRight[i] = Math.max(highestBarInRight[i + 1], input[i]);

		int amountOfWater = 0;
		for (int i = 0; i < n; i++)
			amountOfWater += Math.min(highestBarInLeft[i], highestBarInRight[i]) - input[i];

		System.out.print("input:{");
		for (int i = 0; i < n - 1; i++)
			System.out.print(input[i] + ",");
		System.out.print(input[n - 1] + "}");
		System.out.println(" -> output: " + amountOfWater);
	}

	public static void questionFour(int[] bigger, int[] smaller) {
		System.out.print("Input: [");
		for (int i = 0; i < bigger.length - 1; i++)
			System.out.print(bigger[i] + ",");
		System.out.print(bigger[bigger.length - 1] + "] & [");
		for (int i = 0; i < smaller.length - 1; i++)
			System.out.print(smaller[i] + ",");
		System.out.println(smaller[smaller.length - 1] + "]");
		boolean[] flag = new boolean[smaller.length];
		outer: for (int i = 0; i < smaller.length; i++)
			for (int j = 0; j < bigger.length; j++)
				if (smaller[i] == bigger[j]) {
					flag[i] = true;
					continue outer;
				}

		for (int i = 0; i < flag.length; i++)
			if (flag[i] == false) {
				System.out.println("Output: no");
				return;
			}

		System.out.println("Output: yes");
	}

	public static void questionFive() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = input.nextInt();
		System.out.print("Enter m: ");
		int m = input.nextInt();
		String[][] gameBoard = new String[n + 1][m + 1];
		int selectedColumn = 0;
		int selectedRow = 0;
		int numberOfEmptyCells = n * m;
		String player = "";
		printGameStatus(n, m, gameBoard);
		while (numberOfEmptyCells > 0) {
			System.out.print("Hamed (o) turn >> ");
			player = "o";
			selectedColumn = input.nextInt();
			for (int i = n; i >= 1; i--)
				if (gameBoard[i][selectedColumn] == null) {
					gameBoard[i][selectedColumn] = player;
					selectedRow = i;
					numberOfEmptyCells--;
					break;
				}
			printGameStatus(n, m, gameBoard);
			if (getGameStatus(n, m, gameBoard, selectedRow, selectedColumn, player))
			{
				input.close();
				return;
			}

			System.out.print("Amir (*) turn >> ");
			player = "*";
			selectedColumn = input.nextInt();
			for (int i = n; i >= 1; i--)
				if (gameBoard[i][selectedColumn] == null) {
					gameBoard[i][selectedColumn] = player;
					selectedRow = i;
					numberOfEmptyCells--;
					break;
				}
			printGameStatus(n, m, gameBoard);
			if (getGameStatus(n, m, gameBoard, selectedRow, selectedColumn, player))
			{
				input.close();
				return;
			}
		}

		System.out.println("Nobody wins the game!");
		input.close();
	}

	private static void printGameStatus(int n, int m, String[][] gameBoard) {
		for (int i = 0; i <= 2 * m; i++)
			System.out.print("=");
		System.out.println();
		for (int i = 1; i <= m; i++)
			System.out.print(" " + i);
		System.out.println();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print("|");
				if (gameBoard[i][j] == null)
					System.out.print(" ");
				else
					System.out.print(gameBoard[i][j]);

			}
			System.out.println("|");
		}
		for (int i = 0; i <= 2 * m; i++)
			System.out.print("=");
		System.out.println();
	}

	private static boolean getGameStatus(int n, int m, String[][] gameBoard, int selectedRow, int selectedColumn,
			String player) {
		String playerName = player.equals("o") ? "Hamed" : "Amir";
		int right = 0;
		for (int i = selectedColumn; i <= m; i++)// for right
			if (gameBoard[selectedRow][i] != null && gameBoard[selectedRow][i].equals(player))
				right++;
			else
				break;

		int left = 0;
		for (int i = selectedColumn; i >= 1; i--)// for left
			if (gameBoard[selectedRow][i] != null && gameBoard[selectedRow][i].equals(player))
				left++;
			else
				break;

		if (right + left > 4) {
			System.out.println(playerName + " Wins!");
			return true;
		}

		int down = 0;
		for (int i = selectedRow; i <= n; i++)
			if (gameBoard[i][selectedColumn] != null && gameBoard[i][selectedColumn].equals(player))
				down++;
			else
				break;

		int up = 0;
		for (int i = selectedRow; i >= 1; i--)
			if (gameBoard[i][selectedColumn] != null && gameBoard[i][selectedColumn].equals(player))
				up++;
			else
				break;

		if (down + up > 4) {
			System.out.println(playerName + " Wins!");
			return true;
		}

		int rightDown = 0;
		for (int i = selectedColumn, j = selectedRow; i <= m && j <= n; i++, j++)
			if (gameBoard[j][i] != null && gameBoard[j][i].equals(player))
				rightDown++;
			else
				break;

		int leftUp = 0;
		for (int i = selectedColumn, j = selectedRow; i >= 1 && j >= 1; i--, j--)
			if (gameBoard[j][i] != null && gameBoard[j][i].equals(player))
				leftUp++;
			else
				break;

		if (rightDown + leftUp > 4) {
			System.out.println(playerName + " Wins!");
			return true;
		}

		int rightUp = 0;
		for (int i = selectedColumn, j = selectedRow; i <= m && j >= 1; i++, j--)
			if (gameBoard[j][i] != null && gameBoard[j][i].equals(player))
				rightUp++;
			else
				break;

		int leftDown = 0;
		for (int i = selectedColumn, j = selectedRow; i >= 1 && j <= n; i--, j++)
			if (gameBoard[j][i] != null && gameBoard[j][i].equals(player))
				leftDown++;
			else
				break;

		if (rightUp + leftDown > 4) {
			System.out.println(playerName + " wins!");
			return true;
		}

		return false;
	}
}
