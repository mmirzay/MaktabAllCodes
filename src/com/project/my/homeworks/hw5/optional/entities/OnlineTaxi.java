package com.project.my.homeworks.hw5.optional.entities;

import com.project.my.homeworks.hw5.optional.api.TripMethod;

public class OnlineTaxi {
	private TripMethod tripMethod;
	private TripParameters tripParameters;

	public OnlineTaxi(TripMethod tripMethod, TripParameters tripParameters) {
		this.tripMethod = tripMethod;
		this.tripParameters = tripParameters;
	}

	public int getPrice() {
		switch (tripMethod) {
		case Economic:
			return new EconomicTrip().calculatePrice(tripParameters);
		case Vip:
			return new VipTrip().calculatePrice(tripParameters);
		case Bike:
			return new BikeTrip().calculatePrice(tripParameters);
		default:
			return -1;
		}

	}
}
