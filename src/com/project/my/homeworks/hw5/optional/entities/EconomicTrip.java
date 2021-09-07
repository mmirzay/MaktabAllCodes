package com.project.my.homeworks.hw5.optional.entities;

public class EconomicTrip {
	private int basePrice;
	private double rainyAndPeakTimeRate;
	private double peakTimeRate;
	private double rainyRate;

	public EconomicTrip() {
		basePrice = 5000;
		rainyAndPeakTimeRate = 1.4;
		peakTimeRate = 1.2;
		rainyRate = 1.2;
	}

	public double calculatePrice(TripParameters tripParameters) {
		return 0;
	}
}
