package com.project.my.classcodes.toyfactory.entities;

import com.project.my.classcodes.toyfactory.services.Constants;
import com.project.my.classcodes.toyfactory.services.Print;

public class Customer {
	private int id;
	private String name;
	private double budget;
	private Toy[] purchasedToys;
	private int toyIndex;

	public Customer(int id, String name, double budget) {
		this.id = id;
		this.name = name;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBudget() {
		return budget;
	}

	public boolean buyToy(Toy toy) {
		if (purchasedToys == null)
			purchasedToys = new Toy[Constants.MAX_NUMBER_OF_TOYS];
		if (toyIndex == purchasedToys.length) {
			Print.printErrorMessage("Capacity of purchaed toys is full");
			return false;
		}
		if (budget < toy.getPrice()) {
			Print.printErrorMessage("Not enough budget!");
			return false;
		}
		purchasedToys[toyIndex++] = toy;
		budget -= toy.getPrice();
		return true;
	}

	public Toy[] getToys() {
		Toy[] result = new Toy[toyIndex];
		for (int i = 0; i < toyIndex; i++)
			result[i] = purchasedToys[i];
		return result;
	}

	public void printListOfToys() {
		Print.printTitleMessage("Customer Toys List");
		Print.printArrays(getToys());
	}

}
