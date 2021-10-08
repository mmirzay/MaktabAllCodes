package com.project.my.classcodes.day0716.printgeneric;

public class NumberPrinter<T extends Number> implements PrinterInterface<T> {

	@Override
	public void print(T element) {
		if (element.getClass() == Double.class || element.getClass() == Float.class)
			System.out.println(element.doubleValue());
		else
			System.out.println(element.longValue());
	}

}
