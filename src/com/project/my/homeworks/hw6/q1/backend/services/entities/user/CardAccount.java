package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

public class CardAccount {
	private double balance;

	protected CardAccount() {
		balance = 0;
	}

	protected void increaseBalance(double value) {
		balance += value;
	}

	protected void decreaseBalance(double value) {
		balance -= value;
	}

	protected double getBalance() {
		return balance;
	}
}
