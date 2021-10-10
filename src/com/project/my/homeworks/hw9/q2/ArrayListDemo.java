package com.project.my.homeworks.hw9.q2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> example1 = new ArrayList<>(Arrays.asList(3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1));
		System.out.println("Example1#: " + example1);
		System.out.println("Output: " + removeUglyOrderedPairs(example1));

		ArrayList<Integer> example2 = new ArrayList<>(Arrays.asList(3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 1, 1));
		System.out.println("Example2#: " + example2);
		System.out.println("Output: " + removeUglyOrderedPairs(example2));

		ArrayList<Integer> example3 = new ArrayList<>(Arrays.asList(3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 1));
		System.out.println("Example3#: " + example3);
		System.out.println("Output: " + removeUglyOrderedPairs(example3));

		ArrayList<Integer> example4 = new ArrayList<>(Arrays.asList(1));
		System.out.println("Example4#: " + example4);
		System.out.println("Output: " + removeUglyOrderedPairs(example4));

		ArrayList<Integer> example5 = new ArrayList<>(Arrays.asList());
		System.out.println("Example5#: " + example5);
		System.out.println("Output: " + removeUglyOrderedPairs(example5));
	}

	private static ArrayList<Integer> removeUglyOrderedPairs(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList<>();
		Integer a = null;
		for (int i = 0; i < list.size(); i++)
			if (i % 2 == 0)
				a = list.get(i);
			else if (a != null && a <= list.get(i)) {
				result.add(a);
				result.add(list.get(i));
				a = null;
			}
		return result;
	}
}
