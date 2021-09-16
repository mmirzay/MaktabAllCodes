package com.project.my.homeworks.hw6.q1.frontend.ui;

import java.util.Scanner;

import com.project.my.homeworks.hw6.q1.backend.services.OnlineMarket;

public class UIManager {
	private Scanner input;
	private static final int DASHED_BORDER_LENGTH = 40;
	OnlineMarket onlineMarket;

	public UIManager() {
		input = new Scanner(System.in);
		onlineMarket = new OnlineMarket();
	}

	public void run() {
		while (true) {
			showLoginPage();
			switch (getIntValue("")) {
			case 1: {
				printTitle("Login as Admin");
				String username = getString("Enter username:");
				String password = getString("Enter password:");
				if (onlineMarket.getUsersManager().loginAdmin(username, password)) {
					showAdminPage();
				} else
					printErrorMessage("Invalid username/password!");
			}
				break;
			case 2: {

			}
				break;
			case 3: {
				printTitle("Sign Up");
				String username = getString("Enter Username:");
				String password = getString("Enter Password:");
				String firstName = getString("Enter First Name:");
				String lastName = getString("Enter Last Name:");
				if (onlineMarket.getUsersManager().addNewCustomer(username, password, firstName, lastName))
					printInfoMessage("New Customer added.");
				else
					printErrorMessage("Username is duplicate. Try again please.");
			}
				break;
			case 4:
				return;
			default:
				printErrorMessage("Invalid selection. Try again please!");
			}
			printWaitingMessage();
		}
	}

	public String getOptionalString(String msg) {
		System.out.print(msg + " ");
		return input.nextLine();
	}

	public String getString(String msg) {
		String result = null;
		while (true) {
			result = getOptionalString(msg);
			if (result.isEmpty())
				printErrorMessage("Invalid input!");
			else
				return result;
		}
	}

	public int getIntValue(String msg) {
		while (true)
			try {
				return Integer.parseInt(getString(msg));
			} catch (Exception e) {
				printErrorMessage("Invalid input!");
				if (msg.isEmpty())
					System.out.print(">> ");
			}
	}

	public void showLoginPage() {
		System.out.println("*** Welcome to Online Market ***");
		printTitle("Login Page");
		System.out.println("1- Login as Admin");
		System.out.println("2- Login as Customer");
		System.out.println("3- Sign up a new Customer");
		System.out.println("4- Exit");
		printDashedBorder();
		System.out.print(">> ");
	}

	public void showAdminPage() {
		printTitle("Administrator Page");
		System.out.println("1- Add New Item");
		System.out.println("2- List of All Items");
		System.out.println("3- List of All Customers");
		System.out.println("4- Back");
		printDashedBorder();
		System.out.print(">> ");
	}

	public void printTitle(String title) {
		printDashedBorder();
		for (int i = 0; i < DASHED_BORDER_LENGTH / 2 - title.length() / 2; i++)
			System.out.print(" ");
		System.out.println(title);
		printDashedBorder();
	}

	public void printDashedBorder() {
		for (int i = 0; i < DASHED_BORDER_LENGTH; i++)
			System.out.print("-");
		System.out.println();
	}

	public void printErrorMessage(String msg) {
		System.out.println("| Error: " + msg + " |");
	}

	public void printInfoMessage(String msg) {
		System.out.println(">>> " + msg + " <<<");
	}

	public void printWaitingMessage() {
		System.out.println("_____________ press Enter to continue...");
		input.nextLine();
	}
}
