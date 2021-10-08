package com.project.my.classcodes.day0716.printgeneric;

public class Main {
	public static void main(String[] args) {
		PrinterInterface<Double> doublePrinter = new NumberPrinter<>();
		doublePrinter.print(8.8);
		PrinterInterface<Integer> integerPrinter = new NumberPrinter<>();
		integerPrinter.print(8);
	}
}
