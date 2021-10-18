package com.project.my.homeworks.hw11.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		int max = input.nextInt();
		List<Integer> evens = new ArrayList<>();
		List<Integer> odds = new ArrayList<>();
		for (int i = 0; i <= max; i++)
			if (i % 2 == 0)
				evens.add(i);
			else
				odds.add(i);
		Thread evenThread = new EvenOddThread(evens, "even");
		Thread oddThread = new EvenOddThread(odds, "odd");
		evenThread.start();
		oddThread.start();

		try {
			evenThread.join();
			oddThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Output: " + EvenOddThread.result);
		input.close();

	}
}
