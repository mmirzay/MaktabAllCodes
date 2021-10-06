package com.project.my.classcodes.day0708;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//int numberOfdigits = input.nextInt();
		LinkedList<Integer> digits = new LinkedList<>();// [ ]
		digits.add(1); //[1]
		digits.add(2); // [1, 2]
		digits.add(3); // [1, 2, 3]
		digits.addLast(3); // [ 1 , 2 ,3,  5]
		digits.addFirst(4); // [ 4 , 1 , 2 ,3,  5]
		digits.addFirst(6); // [ 6 , 4 , 1 , 2 , 5]

		for (Integer i : digits)
			System.out.print(i);
		System.out.println();

	}
}
