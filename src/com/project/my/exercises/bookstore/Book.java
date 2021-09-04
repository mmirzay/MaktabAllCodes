package com.project.my.exercises.bookstore;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/19/2021
 */
public class Book {
	private String name;
	private Author author;
	private Subject subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", subject=" + subject + "]";
	}


}
