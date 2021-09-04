package com.project.my.homeworks.hw2.api;

import com.project.my.homeworks.hw2.entities.MilitaryBarracks;

public class GameController {
	private MilitaryBarracks barracks;
	private boolean isTestFinished;

	public void startGame() {
		barracks = new MilitaryBarracks();
		isTestFinished = false;
		barracks.readySoldiers();
		while (isTestFinished == false) {
			barracks.startTest();
			barracks.printReport();
			if (barracks.getCorporalsPercentage() < GameConstants.TEST_THRESHOLD) {
				isTestFinished = true;
				GameMessages.showMessage("Test is Finished");
			}
		}
	}

	public void showFinalReport() {
		if (isTestFinished == false) {
			GameMessages.showMessage("No Game Started!");
			return;
		}
		barracks.printReport();
	}
}
