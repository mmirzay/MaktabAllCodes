package com.project.my.homeworks.hw6.q1.entities.item;

public class Book extends Readable {
	private String authorName;

	public Book(String title, String authorName, String code, double price) {
		super(title, code, price);
		this.authorName = authorName;

	}

	public String getAuthorName() {
		return authorName;
	}

}
