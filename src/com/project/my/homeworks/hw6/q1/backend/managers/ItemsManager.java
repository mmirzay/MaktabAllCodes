package com.project.my.homeworks.hw6.q1.backend.managers;

import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class ItemsManager {
	private Item[] items;
	private int itemIndex;

	public ItemsManager(int numberOfAllItems) {
		items = new Item[numberOfAllItems];
		itemIndex = 0;
	}

	public void addNewItem(Item item) {
		items[itemIndex++] = item;
	}

	public boolean isDuplicateCode(String code) {
		for (Item item : items)
			if (item == null)
				break;
			else if (item.getCode().equalsIgnoreCase(code))
				return true;
		return false;
	}

	public boolean isItemArrayFull() {
		return itemIndex == items.length;
	}
}
