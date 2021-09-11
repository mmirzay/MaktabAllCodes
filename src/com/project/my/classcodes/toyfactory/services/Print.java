package com.project.my.classcodes.toyfactory.services;

public class Print {
	public static void printErrorMessage(String msg) {
		for (int i = 0; i < msg.length(); i++)
			System.out.print("=");
		System.out.println();
		System.out.println(msg);
		for (int i = 0; i < msg.length(); i++)
			System.out.print("=");
	}

	public static void printArrays(Object[] array) {
		if (array.length == 0) {
			printErrorMessage("List is Empty");
			return;
		}

		int row = 1;
		for (Object obj : array)
			System.out.printf("#%d- %s%n", row++, obj.toString());
	}

	public static void printTitleMessage(String msg) {
		for (int i = 0; i < msg.length(); i++)
			System.out.print("+");
		System.out.println();
		for (int i = 0; i < msg.length() / 2; i++)
			System.out.print(" ");
		System.out.println(msg);
		for (int i = 0; i < msg.length(); i++)
			System.out.print("+");
	}

	public static void showMenu() {
		System.out.println("1. add Toy\n" + "2. add discount for Toy[id]\n" + "3. buy toy\n" + "4. list toyes\n"
				+ "5. customer[id] which one of toy buying\n" + "6. customer[id] buget\n" + "7. exit\n" + " -> ");

	}

	public static void printInputMessage(String msg) {
		System.out.println(">> " + msg + " <<");
		System.out.print("-> ");
	}

	public static void printMessage(String msg) {
		System.out.println("# " + msg + " #");
	}
}
