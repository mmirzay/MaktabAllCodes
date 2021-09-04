package com.project.my.classcodes;

public class Class0521 {

	public static void main(String[] args) {
		Integer num = Integer.valueOf(10);
		getPlus(num);
		System.out.println("Number in main: " + num);

	}

	static void getPlus(Integer num) {
		System.out.println("num before: " + num);
		num = Integer.valueOf(11);
		System.out.println("num after: " + num);
	}
}
