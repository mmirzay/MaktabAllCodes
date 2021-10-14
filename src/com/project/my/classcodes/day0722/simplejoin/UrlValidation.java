package com.project.my.classcodes.day0722.simplejoin;

public class UrlValidation implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("validating download...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done validation...");
	}

}
