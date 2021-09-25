package com.project.my.homeworks.hw7.q2;

public class PhysicalNewspaperSubscription extends NewspaperSubscription {

	public PhysicalNewspaperSubscription(String name) {
		super(name);
	}

	@Override
	protected void setAddress(String address) {
		this.address = address;
		if (address.matches("(.)*(\\d)(.)*") == false) {
			rate = 0;
			System.out.println("Error in PhysicalNewspaperSubscription");
			return;
		}
		rate = 15;
	}

}
