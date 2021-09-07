package com.project.my.homeworks.hw5.optional.entities;

import com.project.my.homeworks.hw5.optional.api.Constants;

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
		int source = tripParameters.getSource();
		int destination = tripParameters.getDestination();
		boolean isRainy = tripParameters.isRainy();
		boolean isPeakTime = tripParameters.isPeakTime();
		boolean isRainyAndPeakTime = isRainy && isPeakTime;
		int x = basePrice * Constants.getDistanceCoefficient(source, destination);
		double price = 0;
		if(isRainyAndPeakTime)
			price = x * rainyAndPeakTimeRate;
		else if(isPeakTime)
			price = x * peakTimeRate;
		else if(isRainy)
			price = x * rainyRate;
		else
			price = x;
		return price;
	}
}
