package com.project.my.homeworks.hw7.q2;

public abstract class NewspaperSubscription {
	private String name;
	protected String address;
	protected int rate;

	public NewspaperSubscription(String name) {
		this.name = name;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getAddress() {
		return address;
	}

	protected abstract void setAddress(String address);

	@Override
	public String toString() {
		return "NewspaperSubscription [name=" + name + ", address=" + address + ", rate=" + rate + "]";
	}

}
