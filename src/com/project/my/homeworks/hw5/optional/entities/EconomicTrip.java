package com.project.my.homeworks.hw5.optional.entities;

import com.project.my.homeworks.hw5.optional.api.AreaDistances;

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
		int source = tripParameters.getSource();
		int destination = tripParameters.getDestination();
		boolean isRainy = tripParameters.isRainy();
		boolean isPeakTime = tripParameters.isPeakTime();
		boolean isRainyAndPeakTime = isRainy && isPeakTime;
		int x = basePrice * AreaDistances.getCoefficient(source, destination);
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
