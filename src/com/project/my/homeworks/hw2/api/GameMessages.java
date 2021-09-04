package com.project.my.homeworks.hw2.api;

public class GameMessages {
	public static void showMenu() {
		System.out.println("1- Start Game");
		System.out.println("2- Show Final Report");
		System.out.println("3- Exit");
		System.out.print("-> ");

	}

	public static void showMessage(String msg) {
		System.out.println(">>>>> " + msg + " <<<<<");
	}
}
