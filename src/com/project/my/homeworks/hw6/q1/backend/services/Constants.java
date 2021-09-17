package com.project.my.homeworks.hw6.q1.backend.services;

public class Constants {
	private static final String SPACES = "%-15s";
	public static final String COLUMNS_SEPARATOR = " | ";
	public static final String ROWS_SEPERATOR = System.lineSeparator();
//			+ "_____________________________________________________________________________________" + System.lineSeparator();

	public static String formatter(String str) {
		return String.format(SPACES, str);
	}
}
