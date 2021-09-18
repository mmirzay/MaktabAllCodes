package com.project.my.homeworks.hw6.q1.backend.services;

import com.project.my.homeworks.hw6.q1.backend.managers.ItemsManager;
import com.project.my.homeworks.hw6.q1.backend.managers.UsersManager;

public class OnlineMarket {
	private int maxNumberOfUsers = Constants.MAX_NUMBER_OF_USERS;
	private int maxNumberOfItems = Constants.MAX_NUMBER_OF_ITEMS;
	private UsersManager userManager;
	private ItemsManager itemsManager;

	public OnlineMarket() {
		userManager = new UsersManager(maxNumberOfUsers);
		itemsManager = new ItemsManager(maxNumberOfItems);
	}

	public UsersManager getUsersManager() {
		return userManager;
	}

	public ItemsManager getItemsManager() {
		return itemsManager;
	}
}
