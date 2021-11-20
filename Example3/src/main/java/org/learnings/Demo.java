package org.learnings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learnings.model.Book;
import org.learnings.model.Publisher;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");

        Publisher publisher = new Publisher("Publisher 1", Arrays.asList(book1, book2));

        session.persist(publisher);

        transaction.commit();

        Book retrievedBook1 = session.get(Book.class, 1);
        Book retrievedBook2 = session.get(Book.class, 2);

        Publisher retrievedPublisher = session.get(Publisher.class, 1);

        System.out.println(retrievedPublisher);

        retrievedPublisher.getBooks().forEach(System.out::println);

        System.out.println(retrievedBook1);
        System.out.println(retrievedBook2);
    }
}
