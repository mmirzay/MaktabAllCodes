package com.project.my.homeworks.hw7.q3;

public class MetalElement extends Element {

	protected MetalElement(String fullName, String symbol, int atomicNumber, double atomicWeight) {
		super(fullName, symbol, atomicNumber, atomicWeight);
	}

	@Override
	protected void describeElement() {
		System.out.println("Metal " + this.toString()+ ":");
		System.out.println("\tMetal elements have high electrical conductivity properties.\n"
				+ "\tMetal elements are also malleable and ductile, allowing them to be worked.");
	}

}
