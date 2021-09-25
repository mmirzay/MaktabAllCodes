package com.project.my.homeworks.hw7.q3;

public class NonMetalElement extends Element {

	protected NonMetalElement(String fullName, String symbol, int atomicNumber, double atomicWeight) {
		super(fullName, symbol, atomicNumber, atomicWeight);
	}

	@Override
	protected void describeElement() {
		System.out.println("Nonmetal " + this.toString() + ":");
		System.out.println("\tNonmetal elements have poor electrical, as well as thermal, conductivity.\n"
				+ "\tThey aren't able to pass electricity or heat as well as metal elements.");
	}

}
