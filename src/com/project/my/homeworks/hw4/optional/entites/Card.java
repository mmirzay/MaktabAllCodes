package com.project.my.homeworks.hw4.optional.entites;

import com.project.my.homeworks.hw4.optional.api.GameConstants;

/**
 * @author MoMi
 *
 */
public class Card {
	private int cardNumber;
	private int[][] numbers;
	private boolean[][] marks;

	public Card(int[][] numbers) {
		this.numbers = numbers;
		marks = new boolean[GameConstants.CARD_ROWS][GameConstants.CARD_COLUMNS];
	}

	public int getNumber(int row, int column) {
		return numbers[row][column];
	}

	public boolean isMarked(int row, int column) {
		return marks[row][column];
	}

	public void markNumber(int number) {
		for (int i = 0; i < GameConstants.CARD_ROWS; i++)
			for (int j = 0; j < GameConstants.CARD_COLUMNS; j++)
				if (numbers[i][j] == number) {
					marks[i][j] = true;
					return;
				}
	}

	public boolean isAllNumbersMarked() {
		for (int i = 0; i < GameConstants.CARD_ROWS; i++)
			for (int j = 0; j < GameConstants.CARD_COLUMNS; j++)
				if (marks[i][j] == false)
					return false;
		return true;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= 25; i++)
			result.append("=");
		result.append(System.lineSeparator());
		result.append("Card #" + getCardNumber());
		result.append(System.lineSeparator());
		for (int i = 0; i <= 25; i++)
			result.append("-");
		result.append(System.lineSeparator());
		for (int i = 0; i < GameConstants.CARD_ROWS; i++) {
			for (int j = 0; j < GameConstants.CARD_COLUMNS; j++)
				if (numbers[i][j] >= 10)
					result.append(numbers[i][j] + " | ");
				else
					result.append(" " + numbers[i][j] + " | ");
			result.append(System.lineSeparator());
		}
		result.append(System.lineSeparator());
		for (int i = 0; i <= 25; i++)
			result.append("-");
		result.append(System.lineSeparator());
		return result.toString();

	}
}
