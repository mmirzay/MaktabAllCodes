package com.project.my.homeworks.hw6.q1.backend.services;

public class Constants {
	public static final int MAX_NUMBER_OF_USERS = 5;
	public static final int MAX_NUMBER_OF_ITEMS = 100;
	public static final int SHOPPING_BASKET_MAX_SIZE = 5;
	private static final String SPACES = "%-15s";
	public static final String COLUMNS_SEPARATOR = " | ";
	public static final String ROWS_SEPERATOR = System.lineSeparator();

	public static String formatter(String str) {
		return String.format(SPACES, str);
	}
}
