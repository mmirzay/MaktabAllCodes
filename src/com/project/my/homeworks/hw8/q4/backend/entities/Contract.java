package com.project.my.homeworks.hw8.q4.backend.entities;

public class Contract {
	private int id;
	private double payment;
	private int year;
	private int length;

	public Contract(int id, double payment, int year, int length) {
		this.id = id;
		this.payment = payment;
		this.year = year;
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPayment() {
		return payment;
	}

	public int getYear() {
		return year;
	}

	public int getLength() {
		return length;
	}

}
