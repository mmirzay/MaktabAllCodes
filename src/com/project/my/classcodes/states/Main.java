package com.project.my.classcodes.states;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		State[] states = new State[31];
		int stateIndex = 0;
		while (true) {
			showMenu();
			switch (Integer.parseInt(input.nextLine())) {
			case 1: {
				System.out.println("Enter state name: ");
				String stateName = input.nextLine();
				State newState = new State();
				newState.setName(stateName);
				states[stateIndex++] = newState;
			}
				break;
			case 2: {
				System.out.println("Enter state name: ");
				String stateName = input.nextLine();
				for (State s : states)
					if (s != null && s.getName().equals(stateName)) {
						System.out.println("Enter city name: ");
						String cityName = input.nextLine();
						City city = new City();
						city.setName(cityName);
						s.addCity(city);
						break;
					}
			}
				break;
			case 3: {
				System.out.println("Enter state name: ");
				String stateName = input.nextLine();
				for (State s : states)
					if (s != null && s.getName().equals(stateName))
						for (City c : s.getCities())
							if (c != null)
								System.out.println(c.getName());

			}
				break;
			case 4:
				input.close();
				return;
			default:
				System.out.println("================================================");
				System.out.println("Invalid selection. try again!");
				System.out.println("================================================");

			}
		}

	}

	static void showMenu() {
		System.out.println("1) Add State");
		System.out.println("2) Add City");
		System.out.println("3) Show Cities");
		System.out.println("4) Exit");
		System.out.print("Please enter a number between 1 and 4 :\n-> ");
	}
}
