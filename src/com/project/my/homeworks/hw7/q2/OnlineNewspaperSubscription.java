package com.project.my.homeworks.hw7.q2;

public class OnlineNewspaperSubscription extends NewspaperSubscription {

	public OnlineNewspaperSubscription(String name) {
		super(name);
	}

	@Override
	protected void setAddress(String address) {
		this.address = address;
		if (address.matches("[^@]*")) {
			rate = 0;
			System.out.println("Error in OnlineNewspaperSubscription");
			return;
		}
		rate = 9;
	}

}
