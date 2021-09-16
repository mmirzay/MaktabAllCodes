package com.project.my.homeworks.hw6.q1.frontend.ui;

import java.util.Scanner;

import com.project.my.homeworks.hw6.q1.backend.services.OnlineMarket;

public class UIManager {
	private Scanner input;
	private static final int DASHED_BORDER_LENGTH = 40;
	OnlineMarket onlineMarket;
	private boolean isRunning;

	public UIManager() {
		input = new Scanner(System.in);
		onlineMarket = new OnlineMarket();
		isRunning = false;
	}

	public void run() {
		isRunning = true;
		while (isRunning) {
			showLoginPage();
			printWaitingMessage();
		}
	}

	private String getOptionalString(String msg) {
		System.out.print(msg + " ");
		return input.nextLine();
	}

	private String getString(String msg) {
		String result = null;
		while (true) {
			result = getOptionalString(msg);
			if (result.isEmpty())
				printErrorMessage("Invalid input!");
			else
				return result;
		}
	}

	private int getIntValue(String msg) {
		while (true)
			try {
				return Integer.parseInt(getString(msg));
			} catch (Exception e) {
				printErrorMessage("Invalid input!");
				if (msg.isEmpty())
					System.out.print(">> ");
			}
	}

	private void showLoginPage() {
		System.out.println("*** Welcome to Online Market ***");
		printTitle("Login Page");
		System.out.println("1- Login as Admin");
		System.out.println("2- Login as Customer");
		System.out.println("3- Sign up a new Customer");
		System.out.println("4- Exit");
		printDashedBorder();
		System.out.print(">> ");

		switch (getIntValue("")) {
		case 1:
			loginAsAdmin();
			break;
		case 2:
			loginAsCustomer();
			break;
		case 3:
			signUp();
			break;
		case 4:
			finish();
			break;
		default:
			printErrorMessage("Invalid selection. Try again please!");
		}
	}

	private void loginAsAdmin() {
		printTitle("Login as Admin");
		String username = getString("Enter username:");
		String password = getString("Enter password:");
		if (onlineMarket.getUsersManager().loginAdmin(username, password))
			showAdminPage();
		else
			printErrorMessage("Invalid username/password!");
	}

	private void loginAsCustomer() {

	}

	private void signUp() {
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

	private void finish() {
		printInfoMessage("Online Market is Closed.");
		isRunning = false;
	}

	private void showAdminPage() {
		printTitle("Administrator Page");
		System.out.println("1- Add New Item");
		System.out.println("2- List of All Items");
		System.out.println("3- List of All Customers");
		System.out.println("4- Back");
		printDashedBorder();
		System.out.print(">> ");
	}

	private void printTitle(String title) {
		printDashedBorder();
		for (int i = 0; i < DASHED_BORDER_LENGTH / 2 - title.length() / 2; i++)
			System.out.print(" ");
		System.out.println(title);
		printDashedBorder();
	}

	private void printDashedBorder() {
		for (int i = 0; i < DASHED_BORDER_LENGTH; i++)
			System.out.print("-");
		System.out.println();
	}

	private void printErrorMessage(String msg) {
		System.out.println("| Error: " + msg + " |");
	}

	private void printInfoMessage(String msg) {
		System.out.println(">>> " + msg + " <<<");
	}

	private void printWaitingMessage() {
		System.out.println("_____________ press Enter to continue...");
		input.nextLine();
	}
}
