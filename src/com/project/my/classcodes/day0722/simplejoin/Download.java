package com.project.my.classcodes.day0722.simplejoin;

public class Download implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("Starting download...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done download...");
	}

}
