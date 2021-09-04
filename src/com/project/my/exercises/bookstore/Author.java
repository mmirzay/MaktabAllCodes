package com.project.my.exercises.bookstore;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/19/2021
 */
public class Author {
	private String name;
	private int numberOfBooks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void addNumberOfBooks() {
		this.numberOfBooks++;
	}

}
