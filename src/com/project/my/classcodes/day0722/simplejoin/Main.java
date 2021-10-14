package com.project.my.classcodes.day0722.simplejoin;

public class Main {
	public static void main(String[] args) {
		Thread scan = new Thread(new ScanVirus());
		scan.start();
		Thread downloadThread = new Thread(new Download());
		downloadThread.start();
		Thread url = new Thread(new UrlValidation());
		url.start();

		try {
			scan.join();
			url.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			downloadThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("done everything.");
	}
}
