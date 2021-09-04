package com.project.my.homeworks.hw4.q2;

public class IntArray {
	private static final int DEFAULT_CAPACITY = 15;
	private int[] array;
	private int capacity;
	private int size;

	public IntArray() {
		capacity = DEFAULT_CAPACITY;
		array = new int[DEFAULT_CAPACITY];
	}

	public IntArray(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];
	}

	public boolean add(int element) {
		if (element == 0)
			return false;

		if (size == capacity)
			doubleCapcity();
		array[size++] = element;
		return true;
	}

	public boolean remove(int element) {
		int foundIndex = -1;
		for (int i = size - 1; i >= 0; i--)
			if (array[i] == element) {
				array[i] = 0;
				foundIndex = i;
				break;
			}

		if (foundIndex == -1)
			return false;

		for (int i = foundIndex; i < size - 1; i++)
			array[i] = array[i + 1];
		array[--size] = 0;

		return true;

	}

	public int get(int index) {
		if (index < 0 || index >= size)
			return 0;
		return array[index];
	}

	public boolean contains(int element) {
		for (int i = 0; i < size; i++)
			if (array[i] == element)
				return true;
		return false;
	}

	public String print() {
		if (size == 0)
			return "{}";

		String print = "{";
		for (int i = 0; i < size - 1; i++)
			print += array[i] + ",";
		print += array[size - 1] + "}";
		return print;
	}

	public int getCapacity() {
		return capacity;
	}

	public int numberOfElements() {
		return size;
	}

	private void doubleCapcity() {
		int[] temp = new int[capacity *= 2];
		for (int i = 0; i < size; i++)
			temp[i] = array[i];
		array = temp;
	}
}
