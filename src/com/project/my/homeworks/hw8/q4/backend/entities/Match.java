package com.project.my.homeworks.hw8.q4.backend.entities;

public class Match {
	private int id;
	private Team home;
	private Team away;
	private Stadium stadium;
	private int year;

	public Match(int id, Team home, Team away, Stadium stadium, int year) {
		this.id = id;
		this.home = home;
		this.away = away;
		this.stadium = stadium;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getHomeTeam() {
		return home;
	}

	public Team getAwayTeam() {
		return away;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public int getYear() {
		return year;
	}

}
