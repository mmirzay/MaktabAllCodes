package com.project.my.homeworks.hw2.q1.entities;

import java.util.Random;

import com.project.my.homeworks.hw2.q1.api.GameConstants;

public class Bullet {
	private int score;
	private int number;

	public int getScore() {
		return score;
	}

	public void fire() {
		score = new Random().nextInt(GameConstants.MAX_RANGE_OF_SCORE + 1);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("Bullet %d : %d", number, score);
	}
}
