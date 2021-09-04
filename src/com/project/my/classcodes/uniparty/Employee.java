package com.project.my.classcodes.uniparty;

public class Employee {
	private int id;
	private Name name;
	private Gender gender;
	private Location location;
	private Name spouseName;
	private boolean isMarried;

	public int getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Name getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(Name spouseName) {
		this.spouseName = spouseName;
		setMarried(true);
	}

	public boolean isMarried() {
		return isMarried;
	}

	private void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

}
