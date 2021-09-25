package com.project.my.homeworks.hw7.q3;

public abstract class Element {
	private String fullName;
	private String symbol;
	private int atomicNumber;
	private double atomicWeight;

	protected Element(String fullName, String symbol, int atomicNumber, double atomicWeight) {
		this.fullName = fullName;
		this.symbol = symbol;
		this.atomicNumber = atomicNumber;
		this.atomicWeight = atomicWeight;
	}

	protected String getFullName() {
		return fullName;
	}

	protected String getSymbol() {
		return symbol;
	}

	protected int getAtomicNumber() {
		return atomicNumber;
	}

	protected double getAtomicWeight() {
		return atomicWeight;
	}

	protected abstract void describeElement();

	@Override
	public String toString() {
		return "Element [symbol=" + symbol + ", atomicNumber=" + atomicNumber + ", atomicWeight=" + atomicWeight + "]";
	}

}
