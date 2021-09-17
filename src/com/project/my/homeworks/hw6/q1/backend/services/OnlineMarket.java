package com.project.my.homeworks.hw6.q1.backend.services;

import com.project.my.homeworks.hw6.q1.backend.managers.ItemsManager;
import com.project.my.homeworks.hw6.q1.backend.managers.UsersManager;

public class OnlineMarket {
	private static final int NUMBER_OF_ALL_CUSTOMERS = 10;
	private static final int NUMBER_OF_ALL_ITEMS = 100;
	private UsersManager userManager;
	private ItemsManager itemsManager;

	public OnlineMarket() {
		userManager = new UsersManager(NUMBER_OF_ALL_CUSTOMERS);
		itemsManager = new ItemsManager(NUMBER_OF_ALL_ITEMS);
	}

	public UsersManager getUsersManager() {
		return userManager;
	}

	public ItemsManager getItemsManager() {
		return itemsManager;
	}
}
