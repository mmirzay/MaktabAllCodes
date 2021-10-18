package com.project.my.homeworks.hw11.q4;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	static final ConcurrentLinkedDeque<Integer> holder = new ConcurrentLinkedDeque<>();

	public static void main(String[] args) throws InterruptedException {
		Resource reource = new Resource();
		Producer producer = new Producer(reource, holder, 10);
		Consumer consumer = new Consumer(reource, holder, 10);
		consumer.setName("consumer");
		producer.setName("producer");
		consumer.start();
		producer.start();

		consumer.join();
		producer.join();

		System.out.println(holder);
	}

}