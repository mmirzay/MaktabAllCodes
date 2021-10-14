package com.project.my.classcodes.day0722;

public class MyThread extends Thread{
	public MyThread(MyRunnable myRunnable) {
		super(myRunnable);
	}

	@Override
	public void run() {
		System.out.println("bye: "+Thread.currentThread().getName());
	}
}
