package org.learnings.model;

public class Book {
    private String isbn;
    private String bookName;
    private Publisher publisher;

    public Book() {
    }

    public Book(String isbn, String bookName, Publisher publisher) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
