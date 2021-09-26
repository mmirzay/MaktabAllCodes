package com.project.my.homeworks.hw8.q2;

import java.io.IOException;

public class ExceptionsDemo {
	static Exception exception = new ExceptionB();

	public static void main(String[] args) {
		try {
			throw exception;
		} catch (ExceptionB e) {
			System.out.println("ExceptionB is thrown: " + e);
			exception = new ExceptionA();
			main(args);
		} catch (ExceptionA e) {
			System.out.println("ExceptionA is thrown: " + e);
			exception = new NullPointerException();
			main(args);
		}catch(NullPointerException e) {
			System.out.println("NullPointerException is thrown: " + e);
			exception = new IOException();
			main(args);
		} catch (IOException e) {
			System.out.println("IOException is thrown: " + e);
			exception = new Exception();
			main(args);
		} catch (Exception e) {
			System.out.println("The Godfather of exceptions is thrown!");
		}
	}
}
