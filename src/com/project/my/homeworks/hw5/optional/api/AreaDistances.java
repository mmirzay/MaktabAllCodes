package com.project.my.homeworks.hw5.optional.api;

public class AreaDistances {
	private static final int[][] DISTANCE_COEFFICIENTS = { { 1, 2, 2, 4, 3 }, { 2, 1, 4, 2, 3 }, { 3, 5, 1, 3, 2 },
			{ 4, 3, 3, 1, 2 }, { 3, 3, 2, 2, 1 } };

	public static int getCoefficient(int area1, int area2) {
		return DISTANCE_COEFFICIENTS[area1][area2];
	}
}
