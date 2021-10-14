package com.project.my.classcodes.day0722;

public class Main {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.setPriority(Thread.MAX_PRIORITY);
		myThread.start();
		System.out.println("hello");
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		System.out.println("done");
	}
}
