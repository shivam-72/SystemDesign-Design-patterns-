package com.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Book {

	String author;
	String name;

	Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + "]";
	}
}

class BookCollection {

	private List<Book> bookcollection = new ArrayList<>();;

	void addBook(Book book) {
		bookcollection.add(book);
	}

	void deleteBook(Book b) {
		bookcollection.remove(b);
	}

	public Iterator<Book> createIterator() {
		return new BookIterator(this.bookcollection);
	}

	List<Book> getBook() {
		return bookcollection;
	}

	@Override
	public String toString() {
		return "BookCollection [bookcollection=" + bookcollection + "]";
	}

	private class BookIterator implements Iterator<Book> {
		private List<Book> books;
		private int position = 0;

		public BookIterator(List<Book> bookcollection) {
			books = bookcollection;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return position < books.size();
		}

		@Override
		public Book next() {
			// TODO Auto-generated method stub
			return books.get(position++);
		}

	}

}

public class IteratorPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("cde", "efg");
		Book b2 = new Book("abc", "adb");
		BookCollection bookCollection = new BookCollection();
		bookCollection.addBook(b2);
		bookCollection.addBook(b1);
		bookCollection.deleteBook(b2);
		Iterator<Book>bookIterator=bookCollection.createIterator();
		while(bookIterator.hasNext()) {
			Book book=bookIterator.next();
			System.out.println(book);
		}
	}

}
