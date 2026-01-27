package org.example;

import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create a session object, retrieve it from provider
        Session session = SessionProvider.getSession();

        try {
            // begin our transaction:
            Transaction transaction = session.beginTransaction();

            // create an employee object:
            Employee employee = new Employee("John", "Doe", "j@gmail.com");

            // persist/save/update the entity
            session.persist(employee);

            // close the transaction after retrieving it
            session.getTransaction().commit();
//            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // either way, we want to close the session:
            SessionProvider.closeSession(session);
        }

    }
}
