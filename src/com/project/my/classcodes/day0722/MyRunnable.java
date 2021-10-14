package com.project.my.classcodes.day0722;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("runnable: "+Thread.currentThread().getName());
	}

}
