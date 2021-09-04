package com.project.my.homeworks.hw4.optional;

import java.util.Scanner;

import com.project.my.homeworks.hw4.optional.api.GameController;
import com.project.my.homeworks.hw4.optional.api.GameMessages;
import com.project.my.homeworks.hw4.optional.entites.Player;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GameController gameController = new GameController();
		while (true) {
			GameMessages.showMenu();
			switch (input.nextInt()) {
			case 1:
				if (gameController.getNumberOfAddedPlayers() == 0) {
					GameMessages.showMessage("Add players first.");
					continue;
				}
				gameController.startGame();
				break;
			case 2:
				GameMessages.showInputMessage("Enter player name:");
				String name = input.next();
				Player player = new Player(name);
				gameController.addPlayers(player);
				break;
			case 3:
				if (gameController.getNumberOfAddedPlayers() == 0) {
					GameMessages.showMessage("Add players first.");
					continue;
				}
				gameController.showAllPlayers();
				GameMessages.showInputMessage("Enter player name from the list:");
				String selectedName = input.next();
				gameController.showSelectableCardsList();
				GameMessages.showInputMessage("Select card number from the list:");
				int selectedCard = input.nextInt();
				gameController.addCardForPlayer(selectedName, selectedCard);
				break;
			case 4:
				if (gameController.getNumberOfAddedPlayers() == 0) {
					GameMessages.showMessage("Add players first.");
					continue;
				}
				gameController.showAllPlayers();
				break;
			case 5:
				gameController.showAllCards();
				break;
			case 6:
				input.close();
				return;
			default:
				GameMessages.showMessage("Invalid selection.Try again!");
			}
		}
	}
}
