package com.project.my.homeworks.hw4.optional.entites;

public class Player {
	private String name;
	private Card[] cards;
	private boolean isWinner;

	public Player(String name) {
		this.name = name;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void markNumber(int number) {
		for (int i = 0; i < cards.length; i++) {
			cards[i].markNumber(number);
			if (cards[i].isAllNumbersMarked())
				isWinner = true;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Name: " + name);
		result.append(" >> Cards: ");
		if (cards == null)
			result.append("Not selected yet!");
		else {
			for (int i = 0; i < cards.length - 1; i++)
				result.append(cards[i].getCardNumber() + " , ");
			result.append(cards[cards.length - 1].getCardNumber());
		}
		return result.toString();
	}
}
