package org.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This class will provide methods to open and close sessions while
 * re-using the same SessionFactory
 */
public class SessionProvider {
    private static SessionFactory sessionFactory = null;

    // Every time we get a new session, we don't want to re-create the SessionFactory
    public static Session getSession() {
        // if our SessionFactory isn't created yet, we make it
        if(sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }

        // either way, we return a session object, we're guaranteed to have a valid SessionFactory object
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }
}
