package com.project.my.homeworks.hw5.q2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		IntArray newArray = null;
		Scanner input = new Scanner(System.in);
		while (true) {
			showMenu();
			switch (input.nextInt()) {
			case 1:
				System.out.print("-> Enter the capacity for the array: ");
				newArray = new IntArray(input.nextInt());
				printMessage("New array with capacity " + newArray.getCapacity() + " created!");
				break;
			case 2:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				System.out.print("-> Enter new non-zero element: ");
				printMessage(newArray.add(input.nextInt()) ? "Element added." : "Element must be non-zero integer.");
				break;
			case 3:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				System.out.print("-> Enter element to remove: ");
				printMessage(newArray.remove(input.nextInt()) ? "Element removed." : "Nothing found to remove");
				break;
			case 4:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				newArray.selectionSort(true);
				printMessage("Array has been sorted in ascending order.");
				break;
			case 5:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				newArray.selectionSort(false);
				printMessage("Array has been sorted in descending order.");
				break;
			case 6:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				System.out.print("-> Enter the element: ");
				int search = newArray.search(input.nextInt());
				printMessage(
						search != -1 ? "Element is found at index " + search : "Array does NOT contain the element");
				break;
			case 7:
				if (newArray == null) {
					printMessage("Create new array first.");
					continue;
				}
				printMessage(newArray.print());
				break;
			case 8:
				input.close();
				return;
			default:
				printMessage("Invalid selection. try again!");
			}
		}
	}

	private static void showMenu() {
		System.out.println("1- create new array with specific capacity");
		System.out.println("2- add new element");
		System.out.println("3- remove an element");
		System.out.println("4- sort array in ascending order");
		System.out.println("5- sort array in descending order");
		System.out.println("6- search an element");
		System.out.println("7- print array");
		System.out.println("8- exit");
		System.out.print("-> ");
	}

	private static void printMessage(String msg) {
		for (int i = 0; i <= msg.length() + 4; i++)
			System.out.print(">");
		System.out.println();
		System.out.println("  " + msg);
		for (int i = 0; i <= msg.length() + 4; i++)
			System.out.print("<");
		System.out.println();
	}
}
