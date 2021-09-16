package com.project.my.homeworks.hw6.q1.backend.services;

import com.project.my.homeworks.hw6.q1.backend.entities.user.UsersManager;

public class OnlineMarket {
	private static final int NUMBER_OF_ALL_CUSTOMERS = 10;
	UsersManager userManager;

	public OnlineMarket() {
		userManager = new UsersManager(NUMBER_OF_ALL_CUSTOMERS);
	}

	public UsersManager getUsersManager() {
		return userManager;
	}
}
