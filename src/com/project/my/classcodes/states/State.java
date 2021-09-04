package com.project.my.classcodes.states;

public class State {
	private String name;
	private City[] cities = new City[20];
	private int cityCounter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City[] getCities() {
		return cities;
	}

	public void addCity(City city) {
		if (cityCounter < cities.length)
			cities[cityCounter++] = city;
		else
			System.out.println("All cities are added already.");
	}

}
