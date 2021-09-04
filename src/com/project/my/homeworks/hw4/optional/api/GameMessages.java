package com.project.my.homeworks.hw4.optional.api;

public class GameMessages {
	public static void showMenu() {
		System.out.println("1- Start Game");
		System.out.println("2- Add players");
		System.out.println("3- Add cards for player");
		System.out.println("4- Show All players");
		System.out.println("5- Show All Random Cards");
		System.out.println("6- Exit");
		System.out.print("> ");
	}

	public static void showMessage(String msg) {
		for (int i = 0; i <= msg.length() + 4; i++)
			System.out.print(">");
		System.out.println();
		System.out.println("  " + msg);
		for (int i = 0; i <= msg.length() + 4; i++)
			System.out.print("<");
		System.out.println();
	}

	public static void showInputMessage(String msg) {
		for (int i = 0; i <= msg.length() + 4; i++)
			System.out.print("_");
		System.out.println();
		System.out.println(" " + msg);
		System.out.print(" > ");
	}
}
