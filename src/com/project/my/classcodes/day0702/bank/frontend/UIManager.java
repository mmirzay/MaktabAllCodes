package com.project.my.classcodes.day0702.bank.frontend;

import java.util.Scanner;

import com.project.my.classcodes.day0702.bank.backend.exceptions.ManagerException;
import com.project.my.classcodes.day0702.bank.backend.manager.BankManager;

public class UIManager {
	private BankManager bankManager;
	private Scanner input;

	public UIManager() {
		bankManager = new BankManager();
		input = new Scanner(System.in);
	}

	private void showMenu() {
		System.out.println("1- register user");
		System.out.println("2- add account for user");
		System.out.println("3- transfer money");
		System.out.println("4- show transactions by user id");
		System.out.println("5- show transactions by account number");
		System.out.println("6- exit");
		System.out.println("enter your value");
	}

	public void run() {
		showMenu();

		int select = input.nextInt();
		if(select == 1) {
			String name = input.next();
			try {
				bankManager.registerUser(name);
			} catch (ManagerException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
