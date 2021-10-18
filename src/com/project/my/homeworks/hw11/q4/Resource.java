package com.project.my.homeworks.hw11.q4;

public class Resource {

	private int content = -1;
	private boolean flag;

	public synchronized int get() {
		while (flag == false)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		flag = false;
		notifyAll();
		return content;
	}

	public synchronized void set(int value) {
		while (flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		content = value;
		flag = true;
		notifyAll();
	}

}
