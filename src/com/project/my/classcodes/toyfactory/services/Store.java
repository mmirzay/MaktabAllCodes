package com.project.my.classcodes.toyfactory.services;

import com.project.my.classcodes.toyfactory.entities.Customer;
import com.project.my.classcodes.toyfactory.entities.Toy;
import com.project.my.classcodes.toyfactory.entities.ToyFactory;
import com.project.my.classcodes.toyfactory.entities.ToySize;

public class Store {
	private ToyFactory toyFactory;
	private Customer[] customers;
	private int customerIndex;
	private int toyId;

	public Store() {
		toyFactory = new ToyFactory(Constants.MAX_NUMBER_OF_TOYS);
		customers = new Customer[Constants.MAX_NUMBER_OF_CUSTOMERS];
		customerIndex = 0;
		toyId = 1001;
	}

	public ToyFactory getToyFactory() {
		return toyFactory;
	}

	public void addCustomer(Customer newCustomer) {
		if (customerIndex == customers.length) {
			Print.printErrorMessage("All customers are added!");
			return;
		}

		customers[customerIndex++] = newCustomer;
	}

	public void addNewToy(double basePrice, ToySize size) {
		Toy toy = new Toy(toyId, basePrice, size);
		if (toyFactory.addToy(toy)) {
			Print.printMessage("Toy added successfully with id= " + toyId);
			toyId++;
		}
	}
}
