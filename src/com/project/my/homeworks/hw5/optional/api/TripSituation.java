package com.project.my.homeworks.hw5.optional.api;

public enum TripSituation {
	Rainy, PeakTime, RainyAndPeakTime, None;

	public boolean isPeakTime() {
		return this == RainyAndPeakTime || this == PeakTime;
	}

	public boolean isRainy() {
		return this == RainyAndPeakTime || this == Rainy;
	}
}
