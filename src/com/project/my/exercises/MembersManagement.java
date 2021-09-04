package com.project.my.exercises;

import java.util.Scanner;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 3/9/2021
 */
public class MembersManagement {
	static Scanner input = new Scanner(System.in);
	static Object[][] data;
	static int memberIndex = 0;
	static int numberOfAddedMembers = 0;

	static enum Gender {
		Male, Female;

		static Gender getGender(int g) {
			if (g == 1)
				return Male;
			return Female;
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter maximum number of members you want to manage:\n-> ");
		data = new Object[input.nextInt()][4];
		while (true) {
			showMenu();
			switch (input.nextInt()) {
			case 1:
				addMember();
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				editMember();
				break;
			case 4:
				showMembersList();
				break;
			case 5:
				searchMember();
				break;
			case 6:
				return;
			default:
				System.out.println("================================================");
				System.out.println("Invalid selection. try again!");
				System.out.println("================================================");

			}
		}
	}

	static void showMenu() {
		System.out.println("1) Add Member");
		System.out.println("2) Delete Member");
		System.out.println("3) Edit Member");
		System.out.println("4) Show Member");
		System.out.println("5) Search Member");
		System.out.println("6) Exit");
		System.out.print("Please enter a number between 1 and 6 :\n-> ");
	}

	static void addMember() {
		if (numberOfAddedMembers >= data.length) {
			System.out.println("================================================");
			System.out.println("Maximum number of members is already added.");
			System.out.println("================================================");
			return;
		}

		memberIndex = findEmptyMemberIndex();
		outterLoop: while (true) {
			System.out.print("Enter an integer ID for the member (Ex. 1001):\n-> ");
			int id = input.nextInt();
			for (int i = 0; i < data.length; i++)
				if (data[i][0] != null && data[i][0].equals(id)) {
					System.out.println("================================================");
					System.out.println("This ID is already added. try again.");
					System.out.println("================================================");
					continue outterLoop;
				}
			data[memberIndex][0] = id;
			input.nextLine();
			System.out.print("Enter a name for the member (Ex. Mohsen Mirzaei):\n-> ");
			String name = input.nextLine();
			data[memberIndex][1] = name;
			System.out.print("Enter the age of the member (Ex. 29):\n-> ");
			int age = input.nextInt();
			data[memberIndex][2] = age;
			System.out.print("Select the gender of the member:\n" + " 1- Male\n" + " 2- Female\n-> ");
			Gender gender = Gender.getGender(input.nextInt());
			data[memberIndex][3] = gender;
			numberOfAddedMembers++;
			System.out.println("================================================");
			System.out.println("New member added.");
			System.out.println("================================================");
			break;
		} // while
	}// add member

	static void deleteMember() {
		if (numberOfAddedMembers <= 0) {
			System.out.println("================================================");
			System.out.println("Members List is empty. Add a member first.");
			System.out.println("================================================");
			return;
		}
		System.out.print("Enter ID of member you want to delete:\n-> ");
		int id = input.nextInt();
		boolean removed = false;
		for (int i = 0; i < data.length; i++)
			if (data[i][0] != null && data[i][0].equals(id)) {
				numberOfAddedMembers--;
				data[i][0] = null;
				data[i][1] = null;
				data[i][2] = null;
				data[i][3] = null;
				System.out.println("================================================");
				System.out.printf("Member with ID number %d removed.%n", id);
				System.out.println("================================================");
				removed = true;
			}
		if (!removed) {
			System.out.println("================================================");
			System.out.println("No Such ID to delete!");
			System.out.println("================================================");
		}
	} // delete member

	static void editMember() {
		if (numberOfAddedMembers <= 0) {
			System.out.println("================================================");
			System.out.println("Members List is empty. Add a member first.");
			System.out.println("================================================");
			return;
		}
		System.out.print("Enter ID of member you want to edit:\n-> ");
		int id = input.nextInt();
		boolean edited = false;

		for (int i = 0; i < data.length; i++)
			if (data[i][0] != null && data[i][0].equals(id)) {
				input.nextLine();
				System.out.print("Enter a new name for member (Current Name= " + data[i][1]
						+ "). Enter empty value to skip:\n-> ");
				String name = input.nextLine();
				if (name.isEmpty() == false)
					data[i][1] = name;
				System.out.print("Enter a new age of the member (Current Age=" + data[i][2]
						+ "). Enter empty value to skip:\n-> ");
				String strAge = input.nextLine();
				if (strAge.isEmpty() == false) {
					data[i][2] = Integer.parseInt(strAge);
				}
				System.out.print("Select a new gender of member:\n" + " 1- Male\n" + " 2- Female\n-> ");
				String strGender = input.nextLine();
				if (strGender.isEmpty() == false) {
					data[i][3] = Gender.getGender(Integer.parseInt(strGender));

				}
				System.out.println("================================================");
				System.out.printf("Member with ID number %d edited.%n", id);
				System.out.println("================================================");
				edited = true;
			}
		if (!edited) {
			System.out.println("================================================");
			System.out.println("No Such ID to edit!");
			System.out.println("================================================");
		}
	}

	static void showMembersList() {
		if (numberOfAddedMembers <= 0) {
			System.out.println("================================================");
			System.out.println("Members List is empty. Add a member first.");
			System.out.println("================================================");
			return;
		}
		System.out.println("================================================");
		System.out.println("Members List:");
		int row = 1;
		for (int i = 0; i < data.length; i++)
			if (data[i][0] != null)
				System.out.printf("%d -> ID: %d - Name: %s - Age: %d - Gender: %s%n", row++, data[i][0], data[i][1],
						data[i][2], data[i][3]);
		System.out.println("================================================");
	}// showMember

	static void searchMember() {
		if (numberOfAddedMembers <= 0) {
			System.out.println("================================================");
			System.out.println("Members List is empty. Add a member first.");
			System.out.println("================================================");
			return;
		}
		input.nextLine();
		System.out.print("Enter a value to search:\n-> ");
		String searchKey = input.nextLine();
		System.out.println("================================================");
		System.out.println("Search result:");
		int row = 1;
		for (int i = 0; i < data.length; i++)
			for (int j = 1; j < 4; j++)
				if (searchKey.equalsIgnoreCase(data[i][j].toString()))
					System.out.printf("%d -> ID: %d - Name: %s - Age: %d - Gender: %s%n", row++, data[i][0], data[i][1],
							data[i][2], data[i][3]);
		if (row == 1)
			System.out.println("Nothing found!");
		System.out.println("================================================");

	}

	private static int findEmptyMemberIndex() {
		for (int i = 0; i < data.length; i++)
			if (data[i][0] == null)
				return i;
		return data.length;
	}
}
