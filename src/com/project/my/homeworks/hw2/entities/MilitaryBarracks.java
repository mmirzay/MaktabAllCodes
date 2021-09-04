package com.project.my.homeworks.hw2.entities;

import com.project.my.homeworks.hw2.api.GameConstants;
import com.project.my.homeworks.hw2.api.GameConstants.Rank;

public class MilitaryBarracks {
	private int testNumber = 0;
	private Soldier[] soldiers;

	public void readySoldiers() {
		if (soldiers == null) {
			soldiers = new Soldier[GameConstants.NUMBER_OF_SOLDIERS];
			for (int i = 0; i < soldiers.length; i++) {
				soldiers[i] = new Soldier();
				soldiers[i].setId(i + 1);
			}
		}
	}

	public void startTest() {
		testNumber++;
		for (int i = 0; i < soldiers.length; i++) {
			soldiers[i].shootBullets();
			if (soldiers[i].getFinalScore() >= GameConstants.MAX_RANK_SCORE)
				soldiers[i].promoteRank();
			else
				soldiers[i].degradeRank();
		}
	}

	public void printReport() {
		System.out.println("Shooting Test " + testNumber);
		System.out.println("====================");
		for (int i = 0; i < soldiers.length; i++) {
			System.out.println(soldiers[i].toString());
			if (i != soldiers.length - 1)
				System.out.println("**********************");
		}
		System.out.println("====================");
		System.out.printf("Shooting test %d result: %.2f%s of soldiers are Corporals.%n", testNumber,
				getCorporalsPercentage(), "%");
		System.out.println("====================");
	}

	public double getCorporalsPercentage() {
		double numberOfCorporals = 0;
		for (int i = 0; i < soldiers.length; i++)
			if (soldiers[i].getFinalRank() == Rank.Corporal)
				numberOfCorporals++;
		return numberOfCorporals / GameConstants.NUMBER_OF_SOLDIERS * 100;
	}
}
