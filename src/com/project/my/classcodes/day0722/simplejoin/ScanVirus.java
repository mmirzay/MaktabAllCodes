package com.project.my.classcodes.day0722.simplejoin;

public class ScanVirus implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("Starting scan...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done scan...");

	}

}
