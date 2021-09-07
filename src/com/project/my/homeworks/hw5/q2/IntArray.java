package com.project.my.homeworks.hw5.q2;

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
			doubleCapacity();
		array[size++] = element;
		return true;
	}

	public boolean remove(int element) {
		if (element == 0)
			return false;

		boolean found = false;
		int i = size - 1;
		for (; i >= 0; i--)
			if (array[i] == element) {
				array[i] = 0;
				found = true;
				size--;
			}

		if (found == false)
			return false;
		shrinkCapacity();
		return true;

	}

	public int get(int index) {
		if (index < 0 || index >= size)
			return 0;
		return array[index];
	}

	public int search(int element) {
		for (int i = 0; i < size; i++)
			if (array[i] == element)
				return i;
		return -1;
	}

	void selectionSort(boolean isAscending) {
		for (int i = 0; i < size - 1; i++) {
			int index = i;
			for (int j = i + 1; j < size; j++)
				if (isAscending)
				{
					if (array[j] < array[index])
						index = j;
				}else
					if (array[j] > array[index])
						index = j;
					

			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
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

	private void doubleCapacity() {
		int[] temp = new int[capacity *= 2];
		for (int i = 0; i < size; i++)
			temp[i] = array[i];
		array = temp;
	}

	private void shrinkCapacity() {
		int[] temp = new int[size];
		int j = 0;
		for (int i = 0; i < capacity; i++)
			if (array[i] != 0)
				temp[j++] = array[i];
		array = temp;
		capacity = temp.length;
	}
}
