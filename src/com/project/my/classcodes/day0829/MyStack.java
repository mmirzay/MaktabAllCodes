package com.project.my.classcodes.day0829;

import java.io.Serializable;

public class MyStack<T extends Serializable> {
	private Object[] elements;
	private static final int INIT_CAPACITY = 10;
	private int index;

	public MyStack() {
		this(INIT_CAPACITY);
	}

	public MyStack(int capacity) {
		elements = new Object[capacity];
	}

	public boolean push(T element) {
		if (isFull())
			return false;
		elements[index++] = element;
		return true;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (index > 0)
			index--;
		T result = (T) elements[index];
		elements[index] = null;
		return result;
	}

	@SuppressWarnings("unchecked")
	public T topElement() {
		if (isEmpty())
			return null;
		return (T) elements[index - 1];
	}

	public int getSize() {
		return index;
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public boolean isFull() {
		return index == elements.length;
	}

	public void printElements() {
		if (isEmpty())
			return;
		for (int i = index - 1; i >= 0; i--)
			System.err.println(elements[i].toString());
	}
}
