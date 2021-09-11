package com.project.my.classcodes.toyfactory;

import java.util.Scanner;

import com.project.my.classcodes.toyfactory.entities.ToySize;
import com.project.my.classcodes.toyfactory.services.Print;
import com.project.my.classcodes.toyfactory.services.Store;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Store store = new Store();
		while (true) {
			Print.showMenu();
			int selection = input.nextInt();
			switch (selection) {
			case 1:
				Print.printInputMessage("Please Enter Base Price:");
				double basePrice = input.nextDouble();
				Print.printInputMessage("Please Enter Size of Toy (Small, Medium, Large):");
				String strSize = input.next();
				ToySize size = ToySize.valueOf(strSize.toUpperCase());
				store.addNewToy(basePrice, size);
				break;
			case 2:
				break;
			case 3:
				break;

			}
		}
	}
}
