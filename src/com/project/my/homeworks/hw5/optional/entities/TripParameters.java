package com.project.my.homeworks.hw5.optional.entities;

import com.project.my.homeworks.hw5.optional.api.TripSituation;

public class TripParameters {

	private int source;
	private int destination;
	private TripSituation tripSituation;

	public TripParameters(int source, int destination, TripSituation tripSituation) {
		this.source = source;
		this.destination = destination;
		this.tripSituation = tripSituation;
	}

	public int getSource() {
		return source;
	}

	public int getDestination() {
		return destination;
	}

	public boolean isPeakTime() {
		return tripSituation.isPeakTime();
	}

	public boolean isRainy() {
		return tripSituation.isRainy();
	}

}
