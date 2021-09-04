package com.project.my.exercises.bookstore;

/**
 * @author Mohsen Mirzaei <br/>
 *         <b>Date:</b> 8/19/2021
 */
public class BookStore {
	private Author[] authors = new Author[1000];
	private Book[] books = new Book[1000];
	private int bookIndex;

	boolean isAny = false;

	public void addBook(Book b) {
		if (bookIndex < books.length) {
			books[bookIndex++] = b;
			for (int i = 0; i < authors.length; i++)
				if (authors[i] == null) {
					authors[i] = b.getAuthor();
					authors[i].addNumberOfBooks();
					break;
				} else if (authors[i].getName().equalsIgnoreCase(b.getAuthor().getName())) {
					authors[i].addNumberOfBooks();
					break;
				}
			isAny = true;
		}
	}

	public void showBooksList() {
		if (isAny == false) {
			System.out.println(">>> No result! <<<");
			return;
		}
		int i = 1;
		for (Book b : books)
			if (b != null)
				System.out.println(i++ + "- " + b);
			else
				break;

	}

	public void showBooksBySubject(Subject s) {
		if (isAny == false) {
			System.out.println(">>> No result! <<<");
			return;
		}
		int i = 1;
		for (Book b : books)
			if (b == null)
				break;
			else if (b.getSubject() == s)
				System.out.println(i++ + "- " + b);

	}

	public void showLargestSubject() {
		if (isAny == false) {
			System.out.println(">>> No result! <<<");
			return;
		}
		int numberOfHistories = 0;
		int numberOfSports = 0;
		int numberOfSciences = 0;
		for (Book b : books)
			if (b != null)
				switch (b.getSubject()) {
				case HISTORY:
					numberOfHistories++;
					break;
				case SPORT:
					numberOfSports++;
					break;
				case SCIENCE:
					numberOfSciences++;
					break;
				}
			else
				break;

		int max = Math.max(numberOfHistories, Math.max(numberOfSports, numberOfSciences));

		if (max == numberOfHistories)
			System.out.println("The largest subject is History");
		if (max == numberOfSports)
			System.out.println("The largest subject is Sport");
		if (max == numberOfSciences)
			System.out.println("The largest subject is Science");
	}

	public void showBooksByAuthorName(String name) {
		if (isAny == false) {
			System.out.println(">>> No result! <<<");
			return;
		}
		int i = 1;
		for (Book b : books)
			if (b == null)
				break;
			else if (b.getAuthor().getName().equalsIgnoreCase(name))
				System.out.println(i++ + "- " + b);

	}

	public void showAuthorsList() {
		if (isAny == false) {
			System.out.println(">>> No result! <<<");
			return;
		}
		Author[] sorted = authors.clone();
		insertionSort(sorted);
		int i = 1;
		for (Author a : sorted)
			if (a != null)
				System.out.println(i++ + "- " + a + " - number of books: " + a.getNumberOfBooks());
			else
				break;
	}

	private static void insertionSort(Author[] a) {
		for (int i, k = 0; ++k < a.length;) {
			if (a[k] == null)
				break;
			Author ai = a[i = k];
			if (ai.getNumberOfBooks() > a[i - 1].getNumberOfBooks()) {
				while (--i >= 0 && ai.getNumberOfBooks() > a[i].getNumberOfBooks()) {
					a[i + 1] = a[i];
				}
				a[i + 1] = ai;
			}
		}
	}

}
