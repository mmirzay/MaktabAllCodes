package com.project.my.homeworks.hw5.optional.entities;

public class BikeTrip {
	private int basePrice;
	private double rainyAndPeakTimeRate;
	private double peakTimeRate;
	private double rainyRate;

	public BikeTrip() {
		basePrice = 5000;
		rainyAndPeakTimeRate = 1.5;
		peakTimeRate = 2;
		rainyRate = 0.8;
	}

	public double calculatePrice(TripParameters tripParameters) {
		return 0;
	}
}
