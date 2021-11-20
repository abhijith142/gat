package org.learnings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.learnings.model.Passport;
import org.learnings.model.Person;

public class Demo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Passport passport = new Passport("Passport 1");
        Person person = new Person("Person 1", passport);

        passport.setPerson(person);

        session.save(person);

        Person retrievedPerson = session.get(Person.class, 1);
        System.out.println(retrievedPerson);

        Passport retrievedPassport = session.get(Passport.class, passport.getId());
        System.out.println(retrievedPassport.getPerson());

        transaction.commit();
        session.close();

    }
}
