package com.project.my.homeworks.hw5.optional.entities;

public class TripParameters {

	private int source;
	private int destination;
	private boolean peakTime;
	private boolean rainy;

	public TripParameters(int source, int destination, boolean peakTime, boolean rainy) {
		this.source = source;
		this.destination = destination;
		this.peakTime = peakTime;
		this.rainy = rainy;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public boolean isPeakTime() {
		return peakTime;
	}

	public void setPeakTime(boolean peakTime) {
		this.peakTime = peakTime;
	}

	public boolean isRainy() {
		return rainy;
	}

	public void setRainy(boolean rainy) {
		this.rainy = rainy;
	}
}