package com.project.my.homeworks.hw5.optional.entities;

import com.project.my.homeworks.hw5.optional.api.TripMethod;

public class OnlineTaxi {

	public double getPrice(TripMethod tripMethod, TripParameters tripParameters) {
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
