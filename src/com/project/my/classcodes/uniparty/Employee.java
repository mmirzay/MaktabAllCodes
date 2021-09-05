package com.project.my.classcodes.uniparty;

public class Employee {
	private int id;
	private Name name;
	private Gender gender;
	private Location location;
	private Name spouseName;
	private MarriageStatus marriageStatus;

	public Employee(int id) {
		this.id = id;
		marriageStatus = MarriageStatus.Unmarried;
	}

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
		setMarriageStatus(MarriageStatus.Married);
	}

	public MarriageStatus getMarriageStatus() {
		return marriageStatus;
	}

	public boolean isMarried() {
		return marriageStatus == MarriageStatus.Married;
	}

	public void setMarriageStatus(MarriageStatus marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	@Override
	public String toString() {
		return name + " with Id " + id;
	}

}
