package com.project.my.homeworks.hw9.q3;

public class UnilateralList {
	private static class Node {
		Node next;
		Object element;

		Node(Node next, Object element) {
			this.next = next;
			this.element = element;
		}
	}

	private Node first;
	private int size;

	boolean isEmpty() {
		return first == null;
	}

	int getSize() {
		return size;
	}

	void add(Object e) {
		if (e == null)
			return;
		Node node = new Node(first, e);
		first = node;
		size++;
	}

	void remove(Object e) {
		if (e == null || isEmpty())
			return;

		Node search = first;
		Node prev = null;
		while (search != null) {
			if (e.equals(search.element)) {
				Node next = search.next;
				if (prev != null)
					prev.next = next;
				else
					first = next;
				search.next = null;
				search.element = null;
				size--;
			}
			prev = search;
			search = search.next;
		}
	}

	boolean contain(Object e) {
		if (e == null)
			return false;

		Node search = first;
		while (search != null) {
			if (e.equals(search.element))
				return true;
			search = search.next;
		}
		return false;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "{}";
		StringBuilder result = new StringBuilder("{");
		Node temp = first;
		while (true) {
			result.append(temp.element);
			if (temp.next == null)
				return result.append("}").toString();
			result.append(",");
			temp = temp.next;
		}

	}
}
