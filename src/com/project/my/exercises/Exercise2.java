package com.project.my.exercises;

import java.util.Scanner;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/19/2021
 */
public class Exercise2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = input.nextInt();

		int[] sortedNums = nums.clone();
		insertionSort(sortedNums);
		int changesCounter = 0;
		for (int i = 0; i < n; i++)
			if (sortedNums[i] != nums[i])
				changesCounter++;
		if (changesCounter == 2)
			System.out.println("YES");
		else
			System.out.println("NO");

		input.close();

	}

	private static void insertionSort(int[] a) {
		for (int i, k = 0; ++k < a.length;) {
			int ai = a[i = k];

			if (ai < a[i - 1]) {
				while (--i >= 0 && ai < a[i]) {
					a[i + 1] = a[i];
				}
				a[i + 1] = ai;
			}
		}
	}
}
