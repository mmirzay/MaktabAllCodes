package com.project.my.homeworks.hw8.q3;

import java.io.IOException;

public class RethrowingExceptionDemo {
	public static void main(String[] args) {
		try {
			someMethod2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void someMethod2() throws IOException{
		try {
			someMethod();
		} catch (IOException e) {
			throw e;
		}
	}

	private static void someMethod() throws IOException {
		throw new IOException("Some method");
	}
}
