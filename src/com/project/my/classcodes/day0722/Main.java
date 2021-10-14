package com.project.my.classcodes.day0722;

public class Main {
	public static void main(String[] args) {
		System.out.println("main");
		Thread.currentThread().setPriority(1);
		MyThread myThread = new MyThread(new MyRunnable());
		myThread.start();
	}
}
