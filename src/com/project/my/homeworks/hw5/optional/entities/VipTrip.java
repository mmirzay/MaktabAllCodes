package com.project.my.homeworks.hw5.optional.entities;

public class VipTrip {
	private int basePrice;
	private double rainyAndPeakTimeRate;
	private double peakTimeRate;
	private double rainyRate;

	public VipTrip() {
		basePrice = 10000;
		rainyAndPeakTimeRate = 3;
		peakTimeRate = 2;
		rainyRate = 2;
	}

	public double calculatePrice(TripParameters tripParameters) {
		return 0;
	}
}
