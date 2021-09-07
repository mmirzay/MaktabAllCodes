package com.project.my.homeworks.hw2.q1;

import java.util.Scanner;

import com.project.my.homeworks.hw2.q1.api.GameController;
import com.project.my.homeworks.hw2.q1.api.GameMessages;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/17/2021
 */
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GameController gameController = new GameController();
		while (true) {
			GameMessages.showMenu();
			switch (input.nextInt()) {
			case 1:
				gameController.startGame();
				break;
			case 2:
				gameController.showFinalReport();
				break;
			case 3:
				input.close();
				return;
			default:
				GameMessages.showMessage("Invalid Selection!");
			}
		}
	}
}