package com.project.my.homeworks.hw6.q1.backend.managers;

import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;
import com.project.my.homeworks.hw6.q1.backend.services.entities.item.ItemCategory;

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

	public Item[] getAllItemsByCategory(ItemCategory itemCategory) {
		Item[] temp = new Item[itemIndex];
		int j = 0;
		for (int i = 0; i < itemIndex; i++)
			if (items[i].getItemCategory() == itemCategory)
				temp[j++] = items[i];

		Item[] result = new Item[j];
		for (int i = 0; i < j; i++)
			result[i] = temp[i];
		return result;
	}

	public boolean isAnyAddedItem() {
		return itemIndex != 0;
	}

	public int getItemCount(Item item) {
		return warehouseManager.getItemCount(item.getCode());
	}

	public boolean isItemAvailable(Item item) {
		return getItemCount(item) != 0;
	}

	public Item getItemByCode(String itemCode) {
		for (Item item : items)
			if (item == null)
				break;
			else if (item.getCode().equalsIgnoreCase(itemCode))
				return item;
		return null;
	}

	public void decreaseItemCount(Item item) {
		warehouseManager.decreaseItemCount(item.getCode());
	}
}
