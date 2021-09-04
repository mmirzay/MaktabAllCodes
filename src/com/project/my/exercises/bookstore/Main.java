package com.project.my.exercises.bookstore;

import java.util.Scanner;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/19/2021
 */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BookStore bookStore = new BookStore();
		while (true) {
			showMenu();
			switch (input.nextInt()) {
			case 1:
				input.nextLine();
				System.out.print("Enter author name:\n-> ");
				String authorName = input.nextLine();
				System.out.print("Enter book name:\n-> ");
				String bookName = input.nextLine();
				System.out.println("Select book subject:");
				System.out.println("1- History");
				System.out.println("2- Sport");
				System.out.print("3- Science\n-> ");
				Subject subject;
				switch (input.nextInt()) {
				case 2:
					subject = Subject.SPORT;
					break;
				case 3:
					subject = Subject.SCIENCE;
					break;
				default:
					subject = Subject.HISTORY;
				}

				Author author = new Author();
				author.setName(authorName);
				Book newBook = new Book();
				newBook.setName(bookName);
				newBook.setAuthor(author);
				newBook.setSubject(subject);
				bookStore.addBook(newBook);
				break;
			case 2:
				bookStore.showBooksList();
				break;
			case 3:
				input.nextLine();
				System.out.println("Select the subject:");
				System.out.println("1- Hisotry");
				System.out.println("2- Sport");
				System.out.print("3- Science\n-> ");
				Subject subjectToShow;
				switch (input.nextInt()) {
				case 2:
					subjectToShow = Subject.SPORT;
					break;
				case 3:
					subjectToShow = Subject.SCIENCE;
					break;
				default:
					subjectToShow = Subject.HISTORY;
				}
				bookStore.showBooksBySubject(subjectToShow);
				break;
			case 4:
				bookStore.showLargestSubject();
				break;
			case 5:
				bookStore.showAuthorsList();
				break;
			case 6:
				input.nextLine();
				System.out.print("Enter Author name:\n-> ");
				String authorNameToShow = input.nextLine();
				bookStore.showBooksByAuthorName(authorNameToShow);
				break;
			case 7:
				input.close();
				return;
			default:
			}
		}
	}

	public static void showMenu() {
		System.out.println("1) Add Book");
		System.out.println("2) Show All Books");
		System.out.println("3) Show Books by Subject");
		System.out.println("4) Show Largest Subject");
		System.out.println("5) Show All Authors");
		System.out.println("6) Show Books by Author");
		System.out.println("7) exit");
		System.out.print("Please enter a number between 1 and 7 :\n-> ");
	}
}
