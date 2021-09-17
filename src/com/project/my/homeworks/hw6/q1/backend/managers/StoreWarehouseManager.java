package com.project.my.homeworks.hw6.q1.backend.managers;

public class StoreWarehouseManager {
	private String[] itemCodes;
	private int[] itemCounts;
	private int itemCodeIndex;

	StoreWarehouseManager(int numberOfAllItems) {
		itemCodes = new String[numberOfAllItems];
		itemCounts = new int[numberOfAllItems];
		itemCodeIndex = 0;
	}

	void addItemCount(String itemCode, int count) {
		itemCodes[itemCodeIndex] = itemCode;
		itemCounts[itemCodeIndex] = count;
		itemCodeIndex++;
	}

	int getItemCount(String itemCode) {
		return itemCounts[getItemIndex(itemCode)];
	}

	void decreaseItemCount(String itemCode) {
		itemCounts[getItemIndex(itemCode)]--;
	}

	boolean isItemAvailable(String itemCode) {
		return itemCounts[getItemIndex(itemCode)] != 0;
	}

	private int getItemIndex(String itemCode) {
		for (int i = 0; i < itemCodeIndex; i++)
			if (itemCodes[i].equals(itemCode))
				return i;
		return 0;
	}

}
