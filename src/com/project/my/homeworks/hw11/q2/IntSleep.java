package com.project.my.homeworks.hw11.q2;

public class IntSleep {
	public static void main(String[] args) {
		HelloDaemonThread helloDaemonThread = new HelloDaemonThread();
		helloDaemonThread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		helloDaemonThread.interrupt();
	}
}
