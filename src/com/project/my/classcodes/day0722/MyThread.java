package com.project.my.classcodes.day0722;

public class MyThread extends Thread {

	public MyThread() {
		super();
	}

	@Override
	public void run() {
		System.out.println("MyThread: " + this.getName());
	}
}
