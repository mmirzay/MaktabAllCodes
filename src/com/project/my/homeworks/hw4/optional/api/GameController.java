package com.project.my.homeworks.hw4.optional.api;

import java.util.Random;

import com.project.my.homeworks.hw4.optional.entites.Bingo;
import com.project.my.homeworks.hw4.optional.entites.Card;
import com.project.my.homeworks.hw4.optional.entites.Player;

public class GameController {
	private boolean[] toldNumbers;
	int toldNumbersCounter = 0;
	private Card[] cards;
	private boolean selectedCards[];
	private Player[] players;
	private int playersCounter;
	private Bingo bingo;
	private StringBuilder winnersList;

	public GameController() {
		refreshRandomNumbers();
		produceRandomCards(GameConstants.MAXIMUM_NUMBER_OF_CARDS);
		selectedCards = new boolean[GameConstants.MAXIMUM_NUMBER_OF_CARDS];
		players = new Player[GameConstants.MAXIMUM_NUMBER_OF_CARDS];
		winnersList = new StringBuilder();
	}

	private void produceRandomCards(int numberOfCards) {
		cards = new Card[numberOfCards];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card(produceRandomNumbers());
			cards[i].setCardNumber(i + 1);
			refreshRandomNumbers();
		}

	}

	private int[][] produceRandomNumbers() {
		int[][] numbers = new int[GameConstants.CARD_ROWS][GameConstants.CARD_COLUMNS];
		for (int i = 0; i < GameConstants.CARD_ROWS; i++)
			for (int j = 0; j < GameConstants.CARD_COLUMNS; j++)
				numbers[i][j] = nextRandom();
		return numbers;
	}

	public void showAllPlayers() {
		System.out.println("=========================================");
		System.out.println("Players List: ");
		for (int i = 0; i < playersCounter; i++)
			System.out.println("- " + players[i].toString());
		System.out.println("=========================================");
	}

	public void showAllCards() {
		for (int i = 0; i < cards.length; i++)
			System.out.println(cards[i].toString());
	}

	public void showSelectableCardsList() {
		boolean allCardsSelected = true;
		for (int i = 0; i < selectedCards.length; i++)
			if (selectedCards[i] == false) {
				allCardsSelected = false;
				System.out.println(cards[i].getCardNumber() + "- Card #" + cards[i].getCardNumber());
			}

		if (allCardsSelected)
			GameMessages.showMessage("All cards are selected before");
	}

	public int getNumberOfAddedPlayers() {
		return playersCounter;
	}

	public void addPlayers(Player player) {
		if (playersCounter >= players.length) {
			GameMessages.showMessage("All players are added");
			return;
		}

		for (int i = 0; i < playersCounter; i++)
			if (player.getName().equalsIgnoreCase(players[i].getName())) {
				GameMessages.showMessage("This player is added before.");
				return;
			}

		players[playersCounter++] = player;
		bingo = new Bingo(players);
	}

	public void addCardForPlayer(String name, int cardNumber) {
		Player player = getPlayer(name);
		Card card = getCard(cardNumber);
		Card[] newCards;
		if (player.getCards() == null) {
			newCards = new Card[1];
			newCards[0] = card;
			player.setCards(newCards);
			selectedCards[cardNumber - 1] = true;
			return;
		}
		newCards = new Card[player.getCards().length + 1];
		for (int i = 0; i < player.getCards().length; i++)
			newCards[i] = player.getCards()[i];
		newCards[newCards.length - 1] = card;
		player.setCards(newCards);
		selectedCards[cardNumber - 1] = true;
	}

	private Player getPlayer(String name) {
		for (int i = 0; i < playersCounter; i++)
			if (players[i].getName().equalsIgnoreCase(name))
				return players[i];
		return null;
	}

	private Card getCard(int cardNumber) {
		for (int i = 0; i < cards.length; i++)
			if (cards[i].getCardNumber() == cardNumber)
				return cards[i];
		return null;
	}

	public void startGame() {

		for (int i = 0; i < playersCounter; i++)
			if (players[i].getCards() == null) {
				GameMessages.showMessage("Add cards for player (" + players[i].getName() + ") before.");
				return;
			}

		if (isFinished() == false)
			GameMessages.showMessage("Game is Started");
		while (isFinished() == false) {
			tellNewNumber();
		}
		GameMessages.showMessage("Game is finished");
		System.out.println(winnersList);
	}

	private void tellNewNumber() {
		int newNumber = nextRandom();
		System.out.println("Number " + newNumber + " is told.");
		toldNumbersCounter++;
		toldNumbers[newNumber] = true;
		String[] winners = bingo.play(newNumber).split(" ");
		for (int i = 0; i < winners.length; i++) {
			String winner = winners[i];
			if (winner.length() > 1 && winnersList.indexOf(winner) == -1) {
				winnersList.append("- " + winner + " won at round " + (toldNumbersCounter) + ".");
				winnersList.append(System.lineSeparator());
			}
		}
	}

	private void refreshRandomNumbers() {
		toldNumbers = new boolean[GameConstants.MAXIMUM_NUMBER + 1];
	}

	private int nextRandom() {
		while (true) {
			int newNumber = 1 + new Random().nextInt(GameConstants.MAXIMUM_NUMBER);
			if (toldNumbers[newNumber])
				continue;
			toldNumbers[newNumber] = true;
			return newNumber;
		}
	}

	private boolean isFinished() {
		return toldNumbersCounter == GameConstants.MAXIMUM_NUMBER;
	}
}
