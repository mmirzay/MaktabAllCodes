package com.project.my.homeworks.hw9.q3;

public class LinkedListDemo {
	public static void main(String[] args) {
		UnilateralList myList = new UnilateralList();
		System.out.println("emptyList: " + myList);
		System.out.println("isEmpty: " + myList.isEmpty());
		myList.add("a");
		System.out.println("adding a: " + myList);
		myList.add("b");
		System.out.println("adding b: " + myList);
		myList.add("c");
		System.out.println("adding c: " + myList);
		myList.remove("d");
		System.out.println("removing d: " + myList);
		myList.remove("c");
		System.out.println("removing c: " + myList);
		myList.add("c");
		System.out.println("adding c again: " + myList);
		myList.remove("b");
		System.out.println("removing b: " + myList);
		myList.add("b");
		System.out.println("adding b again: " + myList);
		myList.remove("a");
		System.out.println("removing a: " + myList);
		myList.add("a");
		System.out.println("adding a: " + myList);
		System.out.println("removing a,b,c: " + myList);
		myList.remove("c");
		System.out.println("List: " + myList);
		myList.remove("b");
		System.out.println("List: " + myList);
		myList.remove("a");
		System.out.println("List: " + myList);
		System.out.println("adding a,b,c: " + myList);
		myList.add("a");
		myList.add("b");
		myList.add("c");
		System.out.println("List: " + myList);
		System.out.println("contain(a): " + myList.contain("a"));
		System.out.println("contain(b): " + myList.contain("b"));
		System.out.println("contain(c): " + myList.contain("c"));
		System.out.println("contain(d): " + myList.contain("d"));

	}
}
