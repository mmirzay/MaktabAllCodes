package com.project.my.classcodes.uniparty;

public class Location {
	private static final double UNIVERSIT_LATITUDE = 35.7036;
	private static final double UNIVERSIT_LONGITUDE = 51.3515;
	private static final double EARTH_RADIUS = 6371;

	private double latitude;
	private double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getDistanceFromUniversity() {
		double latitudesDifference = Math.toRadians(latitude - UNIVERSIT_LATITUDE);
		double longitudesDifference = Math.toRadians(longitude - UNIVERSIT_LONGITUDE);
		double universityLatRad = Math.toRadians(UNIVERSIT_LATITUDE);
		double latRad = Math.toRadians(latitude);

		double a = Math.pow(Math.sin(latitudesDifference / 2), 2)
				+ Math.pow(Math.sin(longitudesDifference / 2), 2) * Math.cos(universityLatRad) * Math.cos(latRad);
		double c = 2 * Math.asin(Math.sqrt(a));

		return Math.round(EARTH_RADIUS * c);
	}

	@Override
	public String toString() {
		return latitude + ", " + longitude;
	}

}
