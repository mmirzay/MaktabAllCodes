package com.project.my.homeworks.hw2.q1.entities;

import com.project.my.homeworks.hw2.q1.api.GameConstants;
import com.project.my.homeworks.hw2.q1.api.GameConstants.Rank;

public class Soldier {
	private int id;
	private Rank initialRank = Rank.Corporal;
	private Rank finalRank = Rank.Corporal;
	private Bullet[] bullets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rank getInitialRank() {
		return initialRank;
	}

	public Rank getFinalRank() {
		return finalRank;
	}

	public void promoteRank() {
		if (initialRank == finalRank)
			finalRank = finalRank.next();
		else {
			initialRank = finalRank;
			finalRank = finalRank.next();
		}
	}

	public void degradeRank() {
		if (initialRank == finalRank)
			finalRank = finalRank.previous();
		else {
			initialRank = finalRank;
			finalRank = finalRank.previous();
		}
	}

	public void shootBullets() {
		if (bullets == null) {
			bullets = new Bullet[GameConstants.MAX_NUMBER_OF_BULLETS];
			for (int i = 0; i < bullets.length; i++) {
				bullets[i] = new Bullet();
				bullets[i].setNumber(i + 1);
			}
		}

		for (int i = 0; i < bullets.length; i++)
			bullets[i].fire();
	}

	public int getFinalScore() {
		int finalScore = 0;
		for (int i = 0; i < bullets.length; i++)
			finalScore += bullets[i].getScore();
		return finalScore;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Soldier ID : " + id);
		result.append(System.lineSeparator());
		for (int i = 0; i < bullets.length; i++) {
			result.append(bullets[i].toString());
			result.append(System.lineSeparator());
		}
		result.append("Final Score : " + getFinalScore());
		result.append(System.lineSeparator());
		result.append("Initial Rank : " + getInitialRank());
		result.append(System.lineSeparator());
		result.append("Final Rank : " + getFinalRank());
		return result.toString();
	}
}
