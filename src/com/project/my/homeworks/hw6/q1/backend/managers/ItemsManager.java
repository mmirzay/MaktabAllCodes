package com.project.my.homeworks.hw6.q1.backend.managers;

import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class ItemsManager {
	private Item[] items;
	private int itemIndex;

	public ItemsManager(int numberOfAllItems) {
		items = new Item[numberOfAllItems];
		itemIndex = 0;
	}

	public boolean addNewItem(Item item) {
		return false;
	}

	public boolean isDuplicateCode(String code) {
		for (Item item : items)
			if (item == null)
				return false;
			else if (item.getCode().equalsIgnoreCase(code))
				return true;
		return false;
	}

	public boolean isItemArrayFull() {
		return itemIndex == items.length;
	}
}
