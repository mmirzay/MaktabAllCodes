package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class ShoppingBasket {
	private Item[] items;
	private int itemIndex;

	protected ShoppingBasket(int maxSize) {
		this.items = new Item[maxSize];
		itemIndex = 0;
	}

	protected boolean isFull() {
		return itemIndex == items.length;
	}

	protected boolean isEmpty() {
		return itemIndex == 0;
	}

	protected void addItem(Item item) {
		items[itemIndex++] = item;
	}

	protected Item[] getItems() {
		if (isFull())
			return items;
		Item[] result = new Item[itemIndex];
		int j = 0;
		for (int i = 0; i < items.length; i++)
			if (items[i] != null)
				result[j++] = items[i];
		return result;
	}

	protected int numberOfItems() {
		return itemIndex;
	}

}
