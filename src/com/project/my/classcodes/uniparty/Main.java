package com.project.my.classcodes.uniparty;

public class Main {
	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		System.out.println("1) Add Employee");
		System.out.println("2) Add Spouse of Employee by ID");
		System.out.println("3) Get Marriage Status by ID");
		System.out.println("4) Get Party Invitation Status by ID");
		System.out.println("5) Show Invited Employees List");
		System.out.print("Enter selection >> ");
	}
}
