package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;
import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class ShoppingBasket {
	private Item[] items;
	private int itemIndex;
	private StringBuilder ordersHistory;

	protected ShoppingBasket(int maxSize) {
		this.items = new Item[maxSize];
		itemIndex = 0;
		ordersHistory = new StringBuilder();
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

	protected void removeAllItems() {
		ordersHistory.append("-Order Items: " + itemIndex + " -Final Cost was: " + getFinalCost());
		ordersHistory.append(Constants.ROWS_SEPERATOR);
		items = new Item[items.length];
		itemIndex = 0;
	}

	protected Item removeOrder(int selectedIndex) {
		Item removed = items[selectedIndex];
		items[selectedIndex] = null;
		itemIndex--;
		return removed;
	}

	protected double getFinalCost() {
		double sum = 0;
		if (isEmpty())
			return sum;
		for (Item item : getItems())
			sum += item.getPrice() * (1 - item.getDiscount());
		return sum;
	}

	protected String getOrdersHistory() {
		return ordersHistory.toString();
	}

}
