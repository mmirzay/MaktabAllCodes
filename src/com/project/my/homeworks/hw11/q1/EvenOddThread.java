package com.project.my.homeworks.hw11.q1;

import java.util.ArrayList;
import java.util.List;

public class EvenOddThread extends Thread {
	private List<Integer> ownList;
	static List<Integer> result = new ArrayList<>();
	private static boolean isEven = true;
	private static Integer monitor = 1;

	public EvenOddThread(List<Integer> ownList, String name) {
		this.ownList = ownList;
		this.setName(name);
	}

	@Override
	public void run() {
		synchronized (monitor) {
			for (Integer i : ownList) {
				if (result.isEmpty() && this.getName().equals("odd"))
					try {
						monitor.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				while (!isEven) {
					isEven = !isEven;
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				result.add(i);
				System.out.println("  > Number " + i + " added by thread: " + this.getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isEven = !isEven;
				monitor.notify();
			}
			isEven = !isEven;
			monitor.notifyAll();
		}
	}
}
