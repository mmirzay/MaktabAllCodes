package com.project.my.homeworks.hw8.q4.backend.exceptions;

public class DbException extends Exception {

	public DbException(String msg, Exception e) {
		super(msg, e);
	}

}
