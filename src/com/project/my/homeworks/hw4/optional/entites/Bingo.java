package com.project.my.homeworks.hw4.optional.entites;

import com.project.my.homeworks.hw4.optional.api.GameMessages;

public class Bingo {
	private Player[] players;
	private StringBuilder lastWinner = new StringBuilder();

	public Bingo(Player[] players) {
		this.players = players;
	}

	public String play(int number) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] == null)
				break;
			players[i].markNumber(number);
			if (players[i].isWinner() && lastWinner.indexOf(players[i].getName()) == -1) {
				lastWinner.append(players[i].getName() + " ");
				GameMessages.showMessage(players[i].getName() + " won!");
			}
		}
		return lastWinner.toString();
	}
}
