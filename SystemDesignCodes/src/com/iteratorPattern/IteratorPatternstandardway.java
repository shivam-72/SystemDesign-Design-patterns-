package com.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{

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

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	
}
//any class that wants to support iterator should implement iterator interface
class BookCollection implements Iterable<Book>{

	private Set<Book> bookcollection = new TreeSet<>();;

	void addBook(Book book) {
		bookcollection.add(book);
	}

	void deleteBook(Book b) {
		bookcollection.remove(b);
	}

	@Override
	public Iterator<Book> iterator() {
		// TODO Auto-generated method stub
		return bookcollection.iterator();
	}	

}

public class IteratorPatternstandardway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("cde", "efg");
		Book b2 = new Book("abc", "adb");
		BookCollection bookCollection = new BookCollection();
		bookCollection.addBook(b2);
		bookCollection.addBook(b1);
		bookCollection.deleteBook(b2);
		Iterator<Book>bookIterator=bookCollection.iterator();
		while(bookIterator.hasNext()) {
			Book book=bookIterator.next();
			System.out.println(book);
		}
	}

}
