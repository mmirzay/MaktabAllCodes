package com.project.my.classcodes.uniparty;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int numberOfEmployees = 10;
		University university = new University(numberOfEmployees);
		while (true) {
			showMenu();
			switch (input.nextInt()) {
			case 1: {
				System.out.print("Enter ID >> ");
				int id = input.nextInt();
				System.out.print("Enter first name >> ");
				String firstName = input.next();
				System.out.print("Enter last name >> ");
				String lastName = input.next();
				System.out.print("Enter gender (male/female) >> ");
				Name name = new Name(firstName, lastName);
				String strGender = input.next();
				Gender gender = strGender.equalsIgnoreCase("male") ? Gender.Male : Gender.Female;
				System.out.print("Enter Latitude >> ");
				double latitude = input.nextDouble();
				System.out.print("Enter Longitude >> ");
				double longitude = input.nextDouble();
				Location location = new Location(latitude, longitude);
				Employee newEmployee = new Employee(id);
				newEmployee.setName(name);
				newEmployee.setGender(gender);
				newEmployee.setLocation(location);
				university.addEmployee(newEmployee);
			}
				break;
			case 2: {
				System.out.print("Enter ID >> ");
				int id = input.nextInt();
				System.out.print("Enter first name of spouse >> ");
				String firstName = input.next();
				System.out.print("Enter last name of spouse >> ");
				String lastName = input.next();
				Name name = new Name(firstName, lastName);
				university.addSpouseById(id, name);
			}
				break;
			case 3: {
				System.out.print("Enter ID >> ");
				int id = input.nextInt();
				university.showMarriageStatusById(id);
			}
				break;
			case 4: {
				System.out.print("Enter ID >> ");
				int id = input.nextInt();
				university.showInvitationStatusById(id);
			}
				break;
			case 5:
				university.showInvitationList();
				break;
			case 6:
				input.close();
				return;
			default:
				System.out.println("Invalid Selection!");
			}
			System.out.println("To continue press Enter...");				
			input.nextLine();
			input.nextLine();
		}
	}

	private static void showMenu() {
		System.out.println("1) Add Employee");
		System.out.println("2) Add Spouse of Employee by ID");
		System.out.println("3) Show Marriage Status by ID");
		System.out.println("4) Show Party Invitation Status by ID");
		System.out.println("5) Show Invited Employees List");
		System.out.println("6) Exit");
		System.out.print("Enter selection >> ");
	}
}
