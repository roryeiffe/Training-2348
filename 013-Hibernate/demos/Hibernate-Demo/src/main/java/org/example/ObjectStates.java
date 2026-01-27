package org.example;

import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;

public class ObjectStates {
    public static void main(String[] args) {
        // Transient - object not yet associated with Hibernate session
        Employee employee = new Employee("Peter", "Griffin", "p@gmail.com");

        // Open session and begin transaction
        Session session = SessionProvider.getSession();
        session.beginTransaction();

        // Invoking persist makes the object persistent:
        session.persist(employee);
        employee.setEmail("l@gmail.com");
        employee.setFirstName("Lois");

        // commit the transaction:
        session.getTransaction().commit();

        // once we close the session, it will be in the detached state:
        session.close();

        employee.setFirstName("Brian");

    }
}
