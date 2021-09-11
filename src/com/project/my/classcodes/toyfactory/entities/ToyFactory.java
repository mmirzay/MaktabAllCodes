package com.project.my.classcodes.toyfactory.entities;

import com.project.my.classcodes.toyfactory.services.Print;

public class ToyFactory {
	private Toy[] toys;
	private int numberOfAddedToys;

	public ToyFactory(int numberOfToys) {
		toys = new Toy[numberOfToys];
		numberOfAddedToys = 0;
	}

	public boolean addToy(Toy newToy) {
		if (numberOfAddedToys == toys.length) {
			Print.printErrorMessage("Capacity of added toys is full");
			return false;
		}
		int toyIndex = -1;
		for (int i = 0; i < toys.length; i++)
			if (toys[i] == null) {
				toyIndex = i;
				break;
			}

		toys[toyIndex++] = newToy;
		numberOfAddedToys++;
		return true;
	}

	public void addDiscountForToy(Toy toy, int discount) {
		for (Toy currentToy : toys)
			if (currentToy != null && currentToy.equals(toy)) {
				currentToy.setBasePrice(currentToy.getBasePrice() * (100 - discount / 100));
				;
				return;
			}
		Print.printErrorMessage(toy + " is not Exist");
	}

	public void sellToy(Toy toy) {
		for (int i = 0; i < toys.length; i++)
			if (toys[i] != null && toys[i].equals(toy)) {
				toys[i] = null;
				return;
			}
		Print.printErrorMessage(toy + " is not Exist");
	}

	public Toy[] getToys() {
		Toy[] result = new Toy[numberOfAddedToys];
		int index = 0;
		for (int i = 0; i < toys.length; i++)
			if (toys[i] != null)
				result[index++] = toys[i];
		return result;
	}

	public void showToysList() {
		Print.printTitleMessage("Factory Toy List");
		Print.printArrays(getToys());
	}
}
