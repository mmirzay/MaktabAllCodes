package com.project.my.classcodes.day0723.semaphor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FileCounter {
	private int counter;
	private Semaphore semaphore = new Semaphore(1);

	void incrementCounter() throws InterruptedException {
		semaphore.acquire();
		counter += 1;
		System.out.println("c: "+counter);
		Thread.sleep(1000);
		semaphore.release();
	}

	int getCounter() {
		return this.counter;
	}

	public static void main(String[] args) {
		FileCounter file = new FileCounter();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++)
			executor.submit(new Runnable() {

				@Override
				public void run() {
					try {
						file.incrementCounter();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		
		try {
			executor.awaitTermination(10, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("counter: " + file.getCounter());
		executor.shutdown();
	}
}
