package com.project.my.homeworks.hw11.q2;

public class HelloDaemonThread extends Thread {
	public HelloDaemonThread() {
		this.setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				System.out.println(this.getName() + " Interrupted!");
				break;
			}
		}
	}
}
