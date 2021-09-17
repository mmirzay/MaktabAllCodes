package com.project.my.homeworks.hw6.q1.backend.managers;

import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class ItemsManager {
	private Item[] items;
	private int itemIndex;
	private StoreWarehouseManager warehouseManager;

	public ItemsManager(int numberOfAllItems) {
		items = new Item[numberOfAllItems];
		warehouseManager = new StoreWarehouseManager(numberOfAllItems);
		itemIndex = 0;
	}

	public void addNewItem(Item item, int count) {
		items[itemIndex++] = item;
		warehouseManager.addItemCount(item.getCode(), count);
	}

	public boolean isDuplicateCode(String code) {
		for (Item item : items)
			if (item == null)
				break;
			else if (item.getCode().substring(1).equals(code))
				return true;
		return false;
	}

	public boolean isItemArrayFull() {
		return itemIndex == items.length;
	}

	public Item[] getAllItems() {
		Item[] result = new Item[itemIndex];
		for (int i = 0; i < itemIndex; i++)
			result[i] = items[i];
		return result;
	}

	public boolean isAnyAddedItem() {
		return itemIndex != 0;
	}
}
