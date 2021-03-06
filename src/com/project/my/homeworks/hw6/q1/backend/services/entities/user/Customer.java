package com.project.my.homeworks.hw6.q1.backend.services.entities.user;

import com.project.my.homeworks.hw6.q1.backend.services.Constants;
import com.project.my.homeworks.hw6.q1.backend.services.entities.item.Item;

public class Customer extends User {
	private static final int SHOPPING_BASKET_SIZE = Constants.SHOPPING_BASKET_MAX_SIZE;
	private ShoppingBasket basket;
	private CardAccount card;

	public Customer(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
		basket = new ShoppingBasket(SHOPPING_BASKET_SIZE);
		card = new CardAccount();
	}

	public boolean isShoppingBasketFull() {
		return basket.isFull();
	}

	public boolean isShoppingBasketEmpty() {
		return basket.isEmpty();
	}

	public void addItemToBasket(Item item) {
		basket.addItem(item);
	}

	public Item[] getPurchasedItems() {
		return basket.getItems();
	}

	public int numberOfAllPurchasedItems() {
		return basket.numberOfItems();
	}

	public boolean isAccountBalanceEmpty() {
		return card.getBalance() == 0;
	}

	public double getFinalPurchaseCost() {
		return basket.getFinalCost();
	}

	public boolean hasEnoughAccountBalance() {
		return card.getBalance() >= getFinalPurchaseCost();
	}

	public double getAccountBalance() {
		return card.getBalance();
	}

	public void increaseAccountBalance(double value) {
		card.increaseBalance(value);
	}

	public void submitOrders() {
		card.decreaseBalance(getFinalPurchaseCost());
		basket.removeAllItems();
	}

	public Item cancelOrderByRowNumber(int selectedRow) {
		return basket.removeOrder(selectedRow - 1);
	}

	public String getOrdersHistory() {
		return basket.getOrdersHistory();
	}

}
